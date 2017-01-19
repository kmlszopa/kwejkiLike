package pl.kamilszopa.data;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kamilszopa.model.Category;
import pl.kamilszopa.model.Gif;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kmlsz on 09.12.2016.
 */
@Repository
@Transactional
public class CategoryRepository implements CategoryDao {
//    protected static final List<Category> ALL_CATEGORIES = Arrays.asList(
//            new Category(1,"Osoby"),
//            new Category(2,"Sport"),
//            new Category(3,"Memy")
//    );
    @PersistenceContext
    private EntityManager entityManager;

    public List<Category> getAllCategories(){
        return entityManager.createQuery("from Category").getResultList();
    }
    public Category findById(int id){
        List<Category> all = entityManager.createQuery("from Category where id IN("+id+")").getResultList();
        Category category = all.get(0);
        return category;
    }


}
