package twix.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQuery;

import twix.database.TwixKlienci;
import twix.database.TwixRezerwacja;
import twix.database.TwixWyniki;
import twix.database.qdsl.QTwixKlienci;
import twix.database.qdsl.QTwixRezerwacja;
import twix.database.qdsl.QTwixWyniki;

@Repository
@Transactional
public class KlientRepository extends BaseRepository<TwixKlienci> {
    
    @Autowired
    private RezerwacjaRepository rezerwacjaRepository;
    
    @Autowired
    private RankingRepository rankingRepository;
    
    public boolean isClientByPeselExists(String pesel) {
        return getByPesel(pesel) != null;
    }
    
    public TwixKlienci getByPesel(String pesel) {
        QTwixKlienci twixKlienci = QTwixKlienci.twixKlienci;
        
        return new JPAQuery<TwixKlienci>(entityManager)
                .from(twixKlienci)
                .where(twixKlienci.pesel.eq(pesel))
                .fetchFirst();
    }

    public boolean isClientByDowodExists(String dowod) {
        QTwixKlienci twixKlienci = QTwixKlienci.twixKlienci;
        
        return new JPAQuery<TwixKlienci>(entityManager)
                .from(twixKlienci)
                .where(twixKlienci.nrDowodu.eq(dowod))
                .fetchFirst() != null;
    }
    
    public TwixKlienci getByLogin(String login) {
        QTwixKlienci twixKlienci = QTwixKlienci.twixKlienci;
        
        return new JPAQuery<TwixKlienci>(entityManager)
                .from(twixKlienci)
                .where(twixKlienci.login.eq(login))
                .fetchFirst();
    }
    
    public boolean isClientByLoginExists(String login) {
         return getByLogin(login) != null;
    }

    public TwixKlienci getByLoginAndPassword(String login, String haslo) {
        QTwixKlienci twixKlienci = QTwixKlienci.twixKlienci;
        
        return new JPAQuery<TwixKlienci>(entityManager)
                .from(twixKlienci)
                .where(twixKlienci.login.eq(login))
                .where(twixKlienci.haslo.eq(haslo))
                .fetchFirst();
    }
    
    @Override 
    public void delete(TwixKlienci data) {
        for (TwixWyniki tw : rankingRepository.getIdWyniki(data.getId()))
            rankingRepository.delete(tw);

        for (TwixRezerwacja tr : rezerwacjaRepository.getById(data.getId()))
            rezerwacjaRepository.delete(tr);
            
        sessionFactory.getCurrentSession().delete(data);
    }
}
