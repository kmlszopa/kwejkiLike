package pl.kamilszopa.model;

import javax.persistence.*;

/**
 * Created by kmlsz on 09.12.2016.
 */
@Entity
@Table
public class Gif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private byte[] image;

    private String name;

    private String username;

    private boolean isFavorite;

    private int categoryId;

    public Gif(){}

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Gif(byte[] image, String name, String username, boolean isFavorite, int categoryId) {
        this.image = image;
        this.name = name;
        this.username = username;
        this.categoryId = categoryId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
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
