package pl.kamilszopa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by kmlsz on 09.12.2016.
 */
@Entity
public class Gif {

    @Id
    @GeneratedValue()
    private int id;

    private String name;

    private String username;

    private boolean isFavorite;

    private Category category;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Gif(String name, String username, boolean isFavorite, Category category) {
        this.name = name;
        this.username = username;
        this.isFavorite = isFavorite;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getName()+" "+isFavorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
