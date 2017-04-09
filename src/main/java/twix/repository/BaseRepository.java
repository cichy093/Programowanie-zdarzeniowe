package twix.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public class BaseRepository<T> {

    @Autowired
    protected SessionFactory sessionFactory;
    
    @PersistenceContext
    protected EntityManager entityManager;

    public void save(T data) {
        sessionFactory.getCurrentSession().saveOrUpdate(data);
    }
    
    public void update(T data) {
        sessionFactory.getCurrentSession().update(data);
    }
    
    public void delete(T data) {
        sessionFactory.getCurrentSession().delete(data);
    }
    
}
