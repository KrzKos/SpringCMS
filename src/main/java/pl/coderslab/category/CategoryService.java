package pl.coderslab.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class CategoryService {
    private final CategoryDao categoryDao;

    public void save(Category category) {
        categoryDao.update(category);
    }
    public List<Category> getAll() {
        return categoryDao.getAll();
    }
    public Category findById(long id) {
        return categoryDao.findById(id);
    }
    public void update(Category category) {
        categoryDao.update(category);
    }
    public void delete(Category category) {
        categoryDao.delete(category);
    }
}
