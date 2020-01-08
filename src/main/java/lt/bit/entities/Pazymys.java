package lt.bit.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "pazymiai")
public class Pazymys {
    @Id
    private int id;
    @Column(name = "data")
    private LocalDateTime date;
    @Column(name = "pazymys")
    private int pazymys;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studentas_id")
    private Studentas studentas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getPazymys() {
        return pazymys;
    }

    public void setPazymys(int pazymys) {
        this.pazymys = pazymys;
    }

    public Studentas getStudentas() {
        return studentas;
    }

    public void setStudentas(Studentas studentas) {
        this.studentas = studentas;
    }
}
