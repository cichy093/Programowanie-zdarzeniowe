package twix.database;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Twix_Wyniki")
public class TwixWyniki implements Serializable {
    
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;
    
    @Column(name = "WYNIK")
    private Integer wynik;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_KLIENTA", insertable = false, updatable = false)
    private TwixKlienci klient;
    
    @Column(name = "ID_KLIENTA")
    private Integer idKlienta;
    
    @Column(name = "DATA", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWynik() {
        return wynik;
    }

    public void setWynik(Integer wynik) {
        this.wynik = wynik;
    }

    public Integer getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(Integer idKlienta) {
        this.idKlienta = idKlienta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TwixKlienci getKlient() {
        return klient;
    }
    
    @Override
    public String toString() {
        return klient.getLogin() + "\t" + wynik;
    }
    
}
