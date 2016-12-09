package pl.kamilszopa.data;

import org.springframework.stereotype.Component;
import pl.kamilszopa.model.Gif;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kmlsz on 09.12.2016.
 */
@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "Chris Ramacciotti", false),
            new Gif("ben-and-mike", "Ben Jakuben", true),
            new Gif("book-dominos", "Craig Dennis", false),
            new Gif("compiler-bot", "Ada Lovelace", true),
            new Gif("cowboy-coder", "Grace Hopper", false),
            new Gif("infinite-andrew", "Marissa Mayer", true)
    );

    public Gif findByName(String name) {
        for (Gif gif : ALL_GIFS) {
            if (gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public List<Gif> findByCategoryId(int id) {
        return ALL_GIFS;
    }
}