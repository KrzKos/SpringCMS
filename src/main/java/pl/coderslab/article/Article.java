package pl.coderslab.article;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @NotBlank
    @Size(max = 200)
    private String title;
    @ManyToOne
    private Author author;
    @ManyToMany
    @Size(min = 1)
    private List<Category> categories;
    @NotBlank
    @Size(min = 500)
    @Column(length = 1000)
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    private boolean draft;

    public Article() {
        categories = new ArrayList<>();
    }

}
