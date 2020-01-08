package lt.bit;

import lt.bit.entities.Pazymys;
import lt.bit.entities.Studentas;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lt.bit.HibernateUtils.getEntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        List<Studentas> studentai = uzkrautiStudentus(em);
        printStudents(studentai);
        kursoVidurkis(2018, em);

        em.getTransaction().commit();
        em.close();

    }

    private static List<Studentas> uzkrautiStudentus(EntityManager em) {
        List<Studentas> studentai;
        TypedQuery<Studentas> query = em.createQuery("SELECT s FROM Studentas s", Studentas.class);
        studentai = query.getResultList();
        return studentai;
    }

    private static void printStudents(List<Studentas> studentai) {
        List<Studentas> sortedStudents = sortStudentsByFullName(studentai);
        sortedStudents.forEach(stud -> {
            System.out.println(stud.getVardas() + " " + stud.getPavarde() + " " + stud.getEl_pastas());
            stud.getPazymiai().forEach(paz -> {
                System.out.println(paz.getPazymys());
            });
        });
    }

    private static List<Studentas> sortStudentsByFullName(List<Studentas> studentai) {
        return studentai.stream()
                .sorted(Comparator.comparing(Studentas::getPavarde).thenComparing(Studentas::getVardas))
                .collect(Collectors.toList());
    }

    private static int kursoVidurkis(int metai, EntityManager entityManager) {
        TypedQuery<Pazymys> query = entityManager.createQuery("SELECT p FROM Pazymys p", Pazymys.class);
        List<Pazymys> pazymiai = query.getResultList();

        int result = (int) pazymiai.stream()
                .filter(paz -> paz.getDate().getYear() == metai)
                .mapToInt(Pazymys::getPazymys)
                .average()
                .orElse(0.0);
        System.out.println("Bendras vidurkis " + metai + " metais yra " + result);
        return result;
    }
}
