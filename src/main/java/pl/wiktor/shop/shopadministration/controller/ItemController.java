package pl.wiktor.shop.shopadministration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pl.wiktor.shop.shopadministration.model.dto.request.ItemDTO;
import pl.wiktor.shop.shopadministration.model.entity.Item;

import java.util.List;

public interface ItemController {
    ResponseEntity<ItemDTO> add(@RequestBody ItemDTO itemDTO);
    ResponseEntity<String> update(@PathVariable int idOldItem, @RequestBody ItemDTO itemDTO);
    List<Item> getAll();
    ResponseEntity<String> delete(@PathVariable int id);
}
