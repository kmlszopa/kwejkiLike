package pl.kamilszopa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kamilszopa.data.CategoryRepository;
import pl.kamilszopa.data.GifRepository;
import pl.kamilszopa.model.Category;
import pl.kamilszopa.model.Gif;

import java.util.List;

/**
 * Created by kmlsz on 09.12.2016.
 */
@Controller
public class CategoriesController {
    @Autowired
    private GifRepository gifRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap){
        List<Category> categories =
                categoryRepository.getAllCategories();
        modelMap.put("categories",categories);
        return "categories";
    }
    @RequestMapping("/category/{id}")
    public String category(@PathVariable int id, ModelMap modelMap){
        Category category = categoryRepository.findById(id);
        modelMap.put("category",category);
        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs",gifs);
        return "category";
    }
}