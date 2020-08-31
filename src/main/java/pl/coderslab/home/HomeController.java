package pl.coderslab.home;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.article.ArticleService;

@RequiredArgsConstructor
@Controller
public class HomeController {
    private final ArticleService articleService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("articles", articleService.getLastFive());
        return "article/lastFive";
    }
}
