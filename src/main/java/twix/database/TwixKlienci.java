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
@Table(name = "Twix_Klienci")
public class TwixKlienci implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;
    
    @Column(name = "IMIE")
    private String imie;
    
    @Column(name = "NAZWISKO")
    private String nazwisko;
    
    @Column(name = "PESEL")
    private String pesel;
    
    @Column(name = "NR_DOWODU")
    private String nrDowodu;
    
    @Column(name = "ID_RANGI")
    private Integer idRangi;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_RANGI", insertable = false, updatable = false)
    private TwixSLRangi ranga;
    
    @Column(name = "LOGIN")
    private String login;
    
    @Column(name = "HASLO")
    private String haslo;
    
    @Column(name = "czyADMIN")
    private Integer czyAdmin;
    
    @Column(name = "SUMAPKT")
    private Integer sumaPkt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNrDowodu() {
        return nrDowodu;
    }

    public void setNrDowodu(String nrDowodu) {
        this.nrDowodu = nrDowodu;
    }

    public Integer getIdRangi() {
        return idRangi;
    }

    public void setIdRangi(Integer idRangi) {
        this.idRangi = idRangi;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Integer getCzyAdmin() {
        return czyAdmin;
    }

    public void setCzyAdmin(Integer czyAdmin) {
        this.czyAdmin = czyAdmin;
    }

    public Integer getSumaPkt() {
        return sumaPkt;
    }

    public void setSumaPkt(Integer sumaPkt) {
        this.sumaPkt = sumaPkt;
    }

    public TwixSLRangi getRanga() {
        return ranga;
    }
}
