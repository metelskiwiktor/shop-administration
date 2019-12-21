package pl.wiktor.shop.shopadministration.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wiktor.shop.shopadministration.model.entity.Tag;
import pl.wiktor.shop.shopadministration.repository.TagRepositoryJpa;

@RestController
@RequestMapping("/tag")
public class TagControllerImpl {
    private TagRepositoryJpa tagRepository;

    @Autowired
    public TagControllerImpl(TagRepositoryJpa tagRepository) {
        this.tagRepository = tagRepository;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public void add(@RequestBody Tag tag){
        tagRepository.saveAndFlush(tag);
    }
}
