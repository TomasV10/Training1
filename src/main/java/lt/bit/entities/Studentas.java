package lt.bit.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "studentai")
public class Studentas {
    @Id
    private int id;
    @Column(name = "vardas")
    private String vardas;
    @Column(name = "pavarde")
    private String pavarde;
    @Column(name = "el_pastas")
    private String el_pastas;
    @OneToMany(mappedBy = "studentas",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Pazymys>pazymiai = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getEl_pastas() {
        return el_pastas;
    }

    public void setEl_pastas(String el_pastas) {
        this.el_pastas = el_pastas;
    }

    public List<Pazymys> getPazymiai() {
        return pazymiai;
    }

    public void setPazymiai(List<Pazymys> pazymiai) {
        this.pazymiai = pazymiai;
    }
}
