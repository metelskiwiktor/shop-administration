package pl.wiktor.shop.shopadministration.model.entity;


import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
@Table
public class Category {

    @Id
    @Column(unique = true)
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
