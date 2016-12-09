package pl.kamilszopa.data;

import org.springframework.stereotype.Component;
import pl.kamilszopa.model.Category;
import pl.kamilszopa.model.Gif;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kmlsz on 09.12.2016.
 */
@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "Chris Ramacciotti", false,new Category(3,"memy")),
            new Gif("ben-and-mike", "Ben Jakuben", true,new Category(1,"osoby")),
            new Gif("book-dominos", "Craig Dennis", false,new Category(3,"memy")),
            new Gif("compiler-bot", "Ada Lovelace", true,new Category(3,"memy")),
            new Gif("cowboy-coder", "Grace Hopper", false,new Category(1,"osoby")),
            new Gif("infinite-andrew", "Marissa Mayer", true,new Category(1,"osoby"))
    );

    public Gif findByName(String name) {
        for (Gif gif : ALL_GIFS) {
            if (gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

    public List<Gif> findByFavorites(){
        List<Gif> favs = new ArrayList<>();
        for (Gif gif : ALL_GIFS){
            if(gif.isFavorite()){
                favs.add(gif);
            }
        }
        return favs;
    }
    public List<Gif> findByChars(String name) {
        List<Gif> finded = new ArrayList<>();
        for (Gif gif : ALL_GIFS) {
            if (gif.getName().contains(name)) {
                finded.add(gif);
            }
        }
        return finded;
    }


    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public List<Gif> findByCategoryId(int id) {
        List<Gif> favs = new ArrayList<>();
        for (Gif gif : ALL_GIFS){
            if(gif.getCategory().getId()==id){
                favs.add(gif);
            }
        }
        return favs;
    }
}