package pl.coderslab.article;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
//@NoArgsConstructor
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 200)
    private String title;
    @ManyToOne
    private Author author;
    @ManyToMany
    private List<Category> categories;
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Article() {
        categories = new ArrayList<>();
    }

}
