package pl.wiktor.shop.shopadministration.model.dto.request;

public class TagDTO {
    private int id;
    private String name;

    public TagDTO() {
    }

    public TagDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TagDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
