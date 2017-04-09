package twix.database;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Twix_Bron_Amunicja")
public class TwixBronAmunicja implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_AMUNICJI", insertable = false, updatable = false)
    private TwixSLAmunicji amunicja;

    @Column(name = "ID_AMUNICJI")
    private Integer idAmunicji;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_BRONI", insertable = false, updatable = false)
    private TwixSLBroni bron;
    
    @Column(name = "ID_BRONI")
    private Integer idBroni;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAmunicji() {
        return idAmunicji;
    }

    public void setIdAmunicji(Integer idAmunicji) {
        this.idAmunicji = idAmunicji;
    }

    public Integer getIdBroni() {
        return idBroni;
    }

    public void setIdBroni(Integer idBroni) {
        this.idBroni = idBroni;
    }

    public TwixSLAmunicji getAmunicja() {
        return amunicja;
    }

    public TwixSLBroni getBron() {
        return bron;
    }
}
