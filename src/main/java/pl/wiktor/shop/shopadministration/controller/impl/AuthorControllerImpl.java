package pl.wiktor.shop.shopadministration.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wiktor.shop.shopadministration.controller.AuthorController;
import pl.wiktor.shop.shopadministration.model.dto.request.AuthorDTO;
import pl.wiktor.shop.shopadministration.model.entity.Author;
import pl.wiktor.shop.shopadministration.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping(AuthorControllerImpl.AUTHOR)
public class AuthorControllerImpl implements AuthorController {
    public static final String AUTHOR = "/author";
    public static final String ADD = "/add";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    public static final String GET_ALL = "/getAll";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private AuthorService authorService;

    @Autowired
    public AuthorControllerImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/generate")
    public ResponseEntity<Author> generate() {
        Author author = new Author("Robert C. Martin", "O mnie");
        return ResponseEntity.ok(author);
    }

    @PostMapping(ADD)
    public ResponseEntity<String> add(@RequestBody AuthorDTO authorDTO) {
        logger.info("Trying to add author = '{}'", authorDTO);

        authorService.add(authorDTO);

        logger.info("Successfully added author = '{}'", authorDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = UPDATE + "{idOldAuthor}", consumes = "application/json")
    public ResponseEntity<String> update(@PathVariable int idOldAuthor, @RequestBody AuthorDTO authorDTO) {
        logger.info("Trying to edit author, old author id = '{}', new author = '{}'", idOldAuthor, authorDTO);

        authorService.edit(idOldAuthor, authorDTO);

        logger.info("Author from id = '{}' successfully changed to = '{}'",
                idOldAuthor,
                authorDTO
        );

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(DELETE + "{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        logger.info("Trying to delete author by id = '{}'", id);

        authorService.delete(id);

        logger.info("Successfully deleted author by id = '{}'", id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<Author>> getAll(){
        return ResponseEntity.ok(authorService.getAll());
    }
}
