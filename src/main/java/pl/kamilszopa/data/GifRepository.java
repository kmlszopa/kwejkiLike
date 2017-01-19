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
public class GifRepository implements GifDao {
    /*private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "Chris Ramacciotti", false,new Category(3,"memy")),
            new Gif("ben-and-mike", "Ben Jakuben", true,new Category(1,"osoby")),
            new Gif("book-dominos", "Craig Dennis", false,new Category(3,"memy")),
            new Gif("compiler-bot", "Ada Lovelace", true,new Category(3,"memy")),
            new Gif("cowboy-coder", "Grace Hopper", false,new Category(1,"osoby")),
            new Gif("infinite-andrew", "Marissa Mayer", true,new Category(1,"osoby"))
    );
    */
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Gif findByName(String name) {
        List<Gif> all = entityManager.createQuery("from Gif where name ='"+name+"'").getResultList();
        Gif gif = all.get(0);
        return gif;
    }



    @Override
    public List<Gif> findByFavorites(){
        return entityManager.createQuery("from Gif where is_favorite in(1)").getResultList();

    }
    @Override
    public List<Gif> findByChars(String name) {
        List<Gif> gifList = entityManager.createQuery("from Gif").getResultList();
        List<Gif> finded = new ArrayList<>();
        for (Gif gif : gifList) {
            if (gif.getName().contains(name)) {
                finded.add(gif);
            }
        }
        return finded;
    }


    @Override
    public void save(Gif gif) {
        entityManager.merge(gif);
        return;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Gif> getAll() {
        return entityManager.createQuery("from Gif").getResultList();
    }

    @Override
    public void create(Gif gif) {
        entityManager.persist(gif);
        return;
    }

    @Override
    public void delete(Gif gif) {
        if (entityManager.contains(gif))
            entityManager.remove(gif);
        else
            entityManager.remove(entityManager.merge(gif));
        return;
    }

    @Override
    public List<Gif> findByCategoryId(int id) {

        return entityManager.createQuery("from Gif where id in(" +id+")").getResultList();
    }


}