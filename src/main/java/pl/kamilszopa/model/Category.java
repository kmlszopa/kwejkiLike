package pl.kamilszopa.model;

import javax.persistence.*;

/**
 * Created by kmlsz on 09.12.2016.
 */
@Entity
@Table
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;


    }

    public Category() {
    }
}
