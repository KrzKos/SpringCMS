package pl.coderslab.article;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import pl.coderslab.category.Category;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ArticleService {
    private final ArticleDao articleDao;

    public void save(Article article){
        articleDao.save(article);
    }
    public List<Article> getAll(){
        return articleDao.getAll();
    }
    public List<Article> getLastFive() {
        return articleDao.getLastFive();
    }
    public Article getWithCategory(long id) {
        Article article = articleDao.findById(id);
        Hibernate.initialize(article.getCategories());
        return article;
    }
    public Article findById(long id){
        return articleDao.findById(id);
    }
    public void update(Article article){
        articleDao.update(article);
    }
    public void delete(Article article){
        articleDao.delete(article);
    }



}
