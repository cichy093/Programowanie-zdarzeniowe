package twix.database;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
@Table(name = "Twix_Rezerwacja")
public class TwixRezerwacja implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;
    
    @Column(name = "ID_KLIENTA")
    private Integer idKlienta;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_KLIENTA", insertable = false, updatable = false)
    private TwixKlienci klient;
    
    @Column(name = "DATA", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    @Column(name = "CZAS")
    private Integer czas;
    
    @Column(name = "ID_TORU")
    private Integer idToru;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TORU", insertable = false, updatable = false)
    private TwixSLTorow tor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCzas() {
        return czas;
    }

    public void setCzas(Integer czas) {
        this.czas = czas;
    }

    public Integer getIdToru() {
        return idToru;
    }

    public void setIdToru(Integer idToru) {
        this.idToru = idToru;
    }

    public TwixKlienci getKlient() {
        return klient;
    }

    public TwixSLTorow getTor() {
        return tor;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s %d:00", new SimpleDateFormat("dd/MM/yyyy").format(data),
                tor.getNazwa(), czas);
    }
}
