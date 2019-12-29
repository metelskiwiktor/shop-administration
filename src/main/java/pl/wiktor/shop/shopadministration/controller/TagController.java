package pl.wiktor.shop.shopadministration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pl.wiktor.shop.shopadministration.model.dto.request.TagDTO;
import pl.wiktor.shop.shopadministration.model.entity.Tag;

import java.util.List;

public interface TagController {
    ResponseEntity<String> add(@RequestBody TagDTO tagDTO);
    ResponseEntity<String> delete(@PathVariable int id);
    ResponseEntity<List<Tag>> getAll();
}
