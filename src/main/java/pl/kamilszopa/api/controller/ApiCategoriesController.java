package pl.kamilszopa.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kamilszopa.data.CategoryRepository;
import pl.kamilszopa.model.Category;

import java.util.List;

/**
 * Created by kmlsz on 09.12.2016.
 */


@RequestMapping("/api")
@RestController
public class ApiCategoriesController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> index(){
        List<Category> categories = categoryRepository.getAllCategories();
        return categories;
    }

}

