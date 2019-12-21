package pl.wiktor.shop.shopadministration.model.entity;

import javax.persistence.*;

@Entity
@Table
public class Tag {
    @Id
    @Column(unique = true)
    private String name;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
