package pl.wiktor.shop.shopadministration.service;

import pl.wiktor.shop.shopadministration.model.dto.request.AuthorDTO;
import pl.wiktor.shop.shopadministration.model.entity.Author;

import java.util.List;

public interface AuthorService {
    void add(AuthorDTO authorDTO);
    void edit(int idOldAuthor, AuthorDTO authorDTO);
    void delete(int id);
    List<Author> getAll();
}
