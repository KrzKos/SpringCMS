package pl.coderslab.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class CategoryConverter implements Converter<String, Category> {
    @Autowired
    private CategoryService categoryService;
    @Override
    public Category convert(String source) {
        Category group = categoryService.findById(Integer.parseInt(source));
        return group;
    }
}
