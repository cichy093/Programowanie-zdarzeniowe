package twix.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import twix.database.TwixSLBroni;
import twix.database.qdsl.QTwixSLBroni;

@Repository
@Transactional
public class BronRepository extends BaseRepository<TwixSLBroni> {

    public List<TwixSLBroni> getBronZAmunicja() {
        QTwixSLBroni SLBroni = QTwixSLBroni.twixSLBroni;
        return new JPAQuery<TwixSLBroni>(entityManager)
                .from(SLBroni)
                .fetch();
    }
    
    public List<TwixSLBroni> getBron() {
        QTwixSLBroni SLBroni = QTwixSLBroni.twixSLBroni;
        return new JPAQuery<TwixSLBroni>(entityManager)
                .from(SLBroni)
                .fetch();
    }
}
