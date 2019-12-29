package pl.wiktor.shop.shopadministration.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wiktor.shop.shopadministration.model.dto.request.ItemDTO;
import pl.wiktor.shop.shopadministration.model.entity.*;
import pl.wiktor.shop.shopadministration.model.mapper.ItemMapper;
import pl.wiktor.shop.shopadministration.repository.CategoryRepositoryJpa;
import pl.wiktor.shop.shopadministration.repository.ItemRepositoryJpa;
import pl.wiktor.shop.shopadministration.repository.TagRepositoryJpa;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Transactional
@RestController
@RequestMapping("/item")
public class ItemControllerImpl {
    private ItemRepositoryJpa itemRepositoryJpa;
    private CategoryRepositoryJpa categoryRepositoryJpa;
    private TagRepositoryJpa tagRepositoryJpa;

    @Autowired
    public ItemControllerImpl(ItemRepositoryJpa itemRepositoryJpa, CategoryRepositoryJpa categoryRepositoryJpa, TagRepositoryJpa tagRepositoryJpa) {
        this.itemRepositoryJpa = itemRepositoryJpa;
        this.categoryRepositoryJpa = categoryRepositoryJpa;
        this.tagRepositoryJpa = tagRepositoryJpa;
    }

    @Transactional
    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<ItemDTO> add(@RequestBody ItemDTO itemDTO){
        Item item = ItemMapper.map(itemDTO);
        itemRepositoryJpa.save(item);
        return ResponseEntity.ok(itemDTO);
    }

    @GetMapping("/get")
    public ItemDTO get(){
        //BigDecimal basicPrice, Category category, List<Tag> tags, String name, Stock stock)
        return new ItemDTO(
                new BigDecimal("200"),
                new Discount(5, new BigDecimal(20)),
                new LinkedHashSet<>(Collections.singletonList(new Category("programowanie w Java"))),
                new LinkedHashSet<>(Arrays.asList(new Tag("SQL"), new Tag("Java"))),
                "Książka o Javie",
                new Stock(12),
                new LinkedHashSet<>(Collections.singletonList(new Author("Wiktor Metelski","O autorze")))
        );
    }

    @GetMapping("/getAll")
    public List<Item> getAll(){
        return itemRepositoryJpa.findAll();
    }

    @Transactional
    @GetMapping(value = "/delete", params = "name")
    public void delete(@RequestParam String name){
        Item item = itemRepositoryJpa.getItemByName(name);
        itemRepositoryJpa.delete(item);
    }
}
