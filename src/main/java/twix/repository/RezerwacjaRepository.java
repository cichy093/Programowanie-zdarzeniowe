package twix.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import twix.database.TwixRezerwacja;
import twix.database.qdsl.QTwixKlienci;
import twix.database.qdsl.QTwixRezerwacja;
import twix.login.Login;

@Repository
@Transactional
public class RezerwacjaRepository extends BaseRepository<TwixRezerwacja> {

    public List<TwixRezerwacja> getAll() {
        QTwixRezerwacja twixRezerwacja = QTwixRezerwacja.twixRezerwacja;
        
        return new JPAQuery<TwixRezerwacja>(entityManager)
                .from(twixRezerwacja)
                .fetch();
    }

    public List<TwixRezerwacja> getByLogin(String login) {
        QTwixRezerwacja twixRezerwacja = QTwixRezerwacja.twixRezerwacja;
        QTwixKlienci klient = QTwixKlienci.twixKlienci;
        
        return new JPAQuery<TwixRezerwacja>(entityManager)
                .from(twixRezerwacja, klient)
                .where(twixRezerwacja.idKlienta.eq(klient.id))
                .where(klient.login.eq(login))
                .fetch();
    }

    public List<TwixRezerwacja> getById(Integer id) {
        QTwixRezerwacja twixRezerwacja = QTwixRezerwacja.twixRezerwacja;
        QTwixKlienci klient = QTwixKlienci.twixKlienci;
        
        return new JPAQuery<TwixRezerwacja>(entityManager)
                .from(twixRezerwacja, klient)
                .where(twixRezerwacja.idKlienta.eq(klient.id))
                .where(klient.id.eq(id))
                .fetch();
    }

}
