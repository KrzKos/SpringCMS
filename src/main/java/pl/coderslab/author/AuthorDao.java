package pl.coderslab.author;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    public List<Author> getAll() {
        Query query = entityManager.createQuery("select au from Author au");
        return query.getResultList();
    }
    public Author findById(long id) {
        return entityManager.find(Author.class,id);
    }
    public void save(Author author) {
        entityManager.persist(author);
    }
    public void update(Author author) {
        entityManager.merge(author);
    }
    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author));
    }

}
