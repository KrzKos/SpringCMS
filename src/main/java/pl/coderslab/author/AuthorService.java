package pl.coderslab.author;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class AuthorService {
    private final AuthorDao authorDao;


    public void save(Author author) {
        authorDao.save(author);
    }

    public List<Author> getAll() {
        return authorDao.getAll();
    }

    public Author findById(long id) {
        return authorDao.findById(id);
    }

    public void update(Author author) {
        authorDao.update(author);
    }

    public void delete(Author author) {
        authorDao.delete(author);
    }
}
