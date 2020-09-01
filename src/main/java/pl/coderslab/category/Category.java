package pl.coderslab.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.article.Article;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100)
    @NotBlank(message = "Nie może być pusty")
    @Size(min = 5, message = "Minimum 5 znaków")
    private String name;
    private String description;

    @Override
    public String toString() {
        return id + " " + name + " " + description;
    }

}
