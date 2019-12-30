package pl.wiktor.shop.shopadministration.model.dto.request;

import javax.persistence.Column;

public class AuthorDTO {
    private int id;
    private String name;
    private String aboutAuthor;

    public AuthorDTO() {
    }

    public AuthorDTO(String name, String aboutAuthor) {
        this.name = name;
        this.aboutAuthor = aboutAuthor;
    }

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

    public String getAboutAuthor() {
        return aboutAuthor;
    }

    public void setAboutAuthor(String aboutAuthor) {
        this.aboutAuthor = aboutAuthor;
    }
}
