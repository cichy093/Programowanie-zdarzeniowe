package twix.database;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Twix_SL_Amunicji")
public class TwixSLAmunicji implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;
    
    @Column(name = "KALIBER")
    private String kaliber;
    
    @Column(name = "CENA")
    private Double cena;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKaliber() {
        return kaliber;
    }

    public void setKaliber(String kaliber) {
        this.kaliber = kaliber;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }
}
