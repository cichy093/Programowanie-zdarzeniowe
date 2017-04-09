package twix.database;

import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "Twix_Rezerwacja_Broni")
public class TwixRezerwacjaBroni implements Serializable {
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_BRON_AMUNICJA", insertable = false, updatable = false)
    private TwixBronAmunicja bronAmunicja;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_REZERWACJI", insertable = false, updatable = false)
    private TwixRezerwacja rezerwacja;
    
    @Id
    @Column(name = "ID_BRON_AMUNICJA")
    private Integer idBronAmunicja;
    
    @Id
    @Column(name = "ID_REZERWACJI")
    private Integer idRezerwacji;

    public Integer getIdBronAmunicja() {
        return idBronAmunicja;
    }

    public void setIdBronAmunicja(Integer idBronAmunicja) {
        this.idBronAmunicja = idBronAmunicja;
    }

    public Integer getIdRezerwacji() {
        return idRezerwacji;
    }

    public void setIdRezerwacji(Integer idRezerwacji) {
        this.idRezerwacji = idRezerwacji;
    }

    public TwixBronAmunicja getBronAmunicja() {
        return bronAmunicja;
    }

    public TwixRezerwacja getRezerwacja() {
        return rezerwacja;
    }

}
