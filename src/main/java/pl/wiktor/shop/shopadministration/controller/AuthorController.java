package pl.wiktor.shop.shopadministration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pl.wiktor.shop.shopadministration.model.dto.request.AuthorDTO;
import pl.wiktor.shop.shopadministration.model.entity.Author;

import java.util.List;

public interface AuthorController {
    ResponseEntity<String> add(@RequestBody AuthorDTO authorDTO);
    ResponseEntity<String> update(@PathVariable int idOldAuthor, @RequestBody AuthorDTO authorDTO);
    ResponseEntity<String> delete(@PathVariable int id);
    ResponseEntity<List<Author>> getAll();
}
