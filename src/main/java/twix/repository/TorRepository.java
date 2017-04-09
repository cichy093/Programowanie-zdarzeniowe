package twix.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import twix.database.TwixSLTorow;
import twix.database.qdsl.QTwixSLTorow;

@Repository
@Transactional
public class TorRepository extends BaseRepository<TwixSLTorow> {
    
    public List<TwixSLTorow> getAll() {
        QTwixSLTorow tor = QTwixSLTorow.twixSLTorow;
        
        return new JPAQuery<TwixSLTorow>(entityManager)
                .from(tor)
                .fetch();
    }
    
}
