package pl.wiktor.shop.shopadministration.model.mapper;

import pl.wiktor.shop.shopadministration.model.dto.request.AuthorDTO;
import pl.wiktor.shop.shopadministration.model.entity.Author;

public abstract class AuthorMapper {
    public static Author map(AuthorDTO authorDTO){
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        author.setAboutAuthor(authorDTO.getAboutAuthor());

        return author;
    }
}
