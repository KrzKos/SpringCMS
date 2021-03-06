package pl.coderslab.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.category.Category;
import pl.coderslab.category.CategoryService;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class ArticleController {
    public final Validator validator;

    private final ArticleService articleService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @ModelAttribute("authors")
    public List<Author> getAllAuthors() {
       return authorService.getAll();
    }
    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("articles", articleService.getAll());
        return "article/all";
    }
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("article", new Article());
        return "article/form";
    }
    @PostMapping("/form")
    public String save(@Valid Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "article/form";
        }
        articleService.save(article);
        return "redirect:/article/all";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable long id) {
        Article article = articleService.getWithCategory(id);
        model.addAttribute("article", article);
        return "article/form";
    }
    @PostMapping("/edit/{id}")
    public String update(@Valid Article article, BindingResult result, @PathVariable long id) {
        if(id != article.getId()) {
            return "error";
        }
        if(result.hasErrors()) {
            return "article/form";
        }
        articleService.update(article);
        return "redirect:/article/all";
    }

}
