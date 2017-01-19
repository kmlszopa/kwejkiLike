package pl.kamilszopa.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kamilszopa.model.Gif;

import java.util.List;

/**
 * Created by kmlsz on 09.12.2016.
 */
@Repository
public interface GifDao {

    public void save(Gif gif);

    public List<Gif> getAll();

    public void create(Gif gif);

    public void delete(Gif gif);

    public List<Gif> findByChars(String name);

    public List<Gif> findByFavorites();

    public Gif findByName(String name);

    public List<Gif> findByCategoryId(int id);

}
