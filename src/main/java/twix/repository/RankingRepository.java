package twix.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import twix.database.TwixKlienci;
import twix.database.TwixWyniki;
import twix.database.qdsl.QTwixKlienci;
import twix.database.qdsl.QTwixWyniki;

@Repository
@Transactional
public class RankingRepository extends BaseRepository<TwixWyniki> {

    public List<TwixWyniki> getAllWyniki() {
        QTwixWyniki twixWyniki = QTwixWyniki.twixWyniki;
        
        return new JPAQuery<TwixWyniki>(entityManager)
                .from(twixWyniki)
                .orderBy(twixWyniki.wynik.desc())
                .fetch();
    }
    
    public List<TwixWyniki> getLoginWyniki(String login) {
        QTwixWyniki twixWyniki = QTwixWyniki.twixWyniki;
        
        return new JPAQuery<TwixWyniki>(entityManager)
                .from(twixWyniki)
                .where(twixWyniki.klient().login.eq(login))
                .orderBy(twixWyniki.id.desc())
                .fetch();
    }
    
    public List<TwixWyniki> getIdWyniki(Integer id) {
        QTwixWyniki twixWyniki = QTwixWyniki.twixWyniki;
        
        return new JPAQuery<TwixWyniki>(entityManager)
                .from(twixWyniki)
                .where(twixWyniki.klient().id.eq(id))
                .orderBy(twixWyniki.id.desc())
                .fetch();
    }

    public int getMaxId() {
        QTwixWyniki tw = QTwixWyniki.twixWyniki;
        
        return new JPAQuery<TwixWyniki>(entityManager)
                .select(tw.id.max())
                .from(tw)
                .fetchFirst();
    }
}
