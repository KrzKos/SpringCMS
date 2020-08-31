package pl.coderslab.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("authors", authorService.getAll());
        return "author/all";
    }
    @GetMapping("/form")
    public String addForm(Model model){
        model.addAttribute("author", new Author());
        return "author/form";
    }
    @PostMapping("/form")
    public String save(@ModelAttribute Author author){
        authorService.save(author);
        return "redirect:/author/all";
    }
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable long id, Model model) {
        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        return "author/form";
    }
    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute Author author, @PathVariable long id) {
        if(id != author.getId()) {
            return "error";
        }
        authorService.update(author);
        return "redirect:/author/all";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Author author = authorService.findById(id);
        authorService.delete(author);
        return "redirect:/author/all";
    }
}
