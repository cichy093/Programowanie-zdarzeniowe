package twix.database;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Twix_SL_Rangi")
public class TwixSLRangi implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;
    
    @Column(name = "NAZWA")
    private String nazwa;
    
    @Column(name = "SYMBOL")
    private byte[] symbol;
    
    @Column(name = "ZNIZKA")
    private Integer znizka;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public byte[] getSymbol() {
        return symbol;
    }

    public void setSymbol(byte[] symbol) {
        this.symbol = symbol;
    }

    public Integer getZnizka() {
        return znizka;
    }

    public void setZnizka(Integer znizka) {
        this.znizka = znizka;
    }

}
