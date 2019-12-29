package pl.wiktor.shop.shopadministration.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wiktor.shop.shopadministration.model.entity.Author;
import pl.wiktor.shop.shopadministration.repository.AuthorRepositoryJpa;

@RestController
@RequestMapping("/author")
public class AuthorControllerImpl {
    private AuthorRepositoryJpa authorRepository;

    @Autowired
    public AuthorControllerImpl(AuthorRepositoryJpa authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/generate")
    public ResponseEntity<Author> generate(){
        Author author = new Author("Wiktor Metelski", "O mnie");
        return ResponseEntity.ok(author);
    }
}
