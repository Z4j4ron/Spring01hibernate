package llasso.dao;

import org.springframework.stereotype.Repository;
import pl.llasso.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PublisherDao {
    @PersistenceContext
    EntityManager entityManager;
    public void create(Publisher publisher){
        entityManager.persist(publisher);
    }
    public Publisher readById(Long id){
        return entityManager.find(Publisher.class, id);
    }
    public void update(Publisher publisher){
        entityManager.merge(publisher);
    }
    public void deleteById(Long id){
        Publisher publisher=readById(id);
        entityManager.remove(entityManager.contains(publisher)? publisher:entityManager.merge(publisher));
    }
}
