package pl.wiktor.shop.shopadministration.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wiktor.shop.shopadministration.controller.TagController;
import pl.wiktor.shop.shopadministration.model.dto.request.TagDTO;
import pl.wiktor.shop.shopadministration.model.entity.Tag;
import pl.wiktor.shop.shopadministration.repository.TagRepositoryJpa;
import pl.wiktor.shop.shopadministration.service.TagService;
import pl.wiktor.shop.shopadministration.service.impl.TagServiceImpl;

import java.util.List;

@RestController
@RequestMapping(TagControllerImpl.TAG)
public class TagControllerImpl implements TagController {
    public final static String TAG = "/tag";
    public final static String ADD = "/add";
    public final static String DELETE = "/delete";
    public final static String GET_ALL = "/getAll";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private TagService tagService;

    @Autowired
    public TagControllerImpl(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping(value = ADD, consumes = "application/json")
    public ResponseEntity<String> add(@RequestBody TagDTO tagDTO) {
        logger.info("Trying to add tag = '{}'", tagDTO);

        tagService.add(tagDTO);

        logger.info("Successfully added tag = '{}'", tagDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(DELETE + "/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        logger.info("Trying to delete tag by id = '{}'", id);

        tagService.delete(id);

        logger.info("Successfully deleted tag by id = '{}'", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<Tag>> getAll(){
        return ResponseEntity.ok(tagService.getAll());
    }
}
