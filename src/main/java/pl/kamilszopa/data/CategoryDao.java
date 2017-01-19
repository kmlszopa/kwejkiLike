package pl.kamilszopa.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.multipart.MultipartFile;
import pl.kamilszopa.model.Category;
import pl.kamilszopa.model.Gif;

import java.util.List;

/**
 * Created by kmlsz on 09.12.2016.
 */
public interface CategoryDao {

    public List<Category> getAllCategories();
    public Category findById(int id);

}