package pl.kamilszopa.data;

import org.springframework.stereotype.Component;
import pl.kamilszopa.model.Category;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kmlsz on 09.12.2016.
 */
@Component
public class CategoryRepository {
    protected static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1,"Osoby"),
            new Category(2,"Sport"),
            new Category(3,"Memy")
    );
    public List<Category> getAllCategories(){
        return ALL_CATEGORIES;
    }
    public Category findById(int id){
        for (Category category:ALL_CATEGORIES){
            if (category.getId()==id){
                return category;
            }
        }
        return null;
    }
}
