package pl.coderslab.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;

@RequiredArgsConstructor
@Controller
@RequestMapping("/category")
public class CategoryController {
    public final Validator validator;
    private final CategoryService categoryService;

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("categories", categoryService.getAll());
        return "category/all";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/form";
    }
    @PostMapping("/form")
    public String addCategory(@Valid Category category, BindingResult result){
        if(result.hasErrors()) {
            return "category/form";
        }
        categoryService.save(category);
        return "redirect:/category/all";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Category category = categoryService.findById(id);
        categoryService.delete(category);
        return "redirect:/category/all";
    }

}
