package pl.coderslab.article;

import org.springframework.stereotype.Repository;
import pl.coderslab.author.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Article article){
        article.setCreated(LocalDateTime.now());
        entityManager.persist(article);
    }
    public List<Article> getAll(){
        Query query = entityManager.createQuery("select a from Article a");
        return query.getResultList();
    }
    public Article findById(long id){
        return entityManager.find(Article.class,id);
    }
    public List<Article> getLastFive() {
        Query query = entityManager.createQuery("select a from Article a order by a.created desc");
        query.setMaxResults(5);
        return query.getResultList();

    }
    public void update(Article article){
        //article.setCreated();
        article.setUpdated(LocalDateTime.now());
        entityManager.merge(article);
    }
    public void delete(Article article){
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }
}
