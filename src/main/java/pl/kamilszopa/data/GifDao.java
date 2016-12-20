package pl.kamilszopa.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kamilszopa.model.Gif;

/**
 * Created by kmlsz on 09.12.2016.
 */
@Repository
public interface GifDao extends CrudRepository<Gif,Integer> {


}
