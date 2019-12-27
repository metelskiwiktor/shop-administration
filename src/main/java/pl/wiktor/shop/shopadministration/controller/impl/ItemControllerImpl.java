package pl.wiktor.shop.shopadministration.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wiktor.shop.shopadministration.model.dto.request.ItemDTO;
import pl.wiktor.shop.shopadministration.model.entity.Discount;
import pl.wiktor.shop.shopadministration.model.entity.Item;
import pl.wiktor.shop.shopadministration.model.entity.Stock;
import pl.wiktor.shop.shopadministration.model.mapper.ItemMapper;
import pl.wiktor.shop.shopadministration.repository.CategoryRepositoryJpa;
import pl.wiktor.shop.shopadministration.repository.ItemRepositoryJpa;
import pl.wiktor.shop.shopadministration.repository.TagRepositoryJpa;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Transactional
@RestController
@RequestMapping("item/")
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
    @PostMapping(value = "add/", consumes = "application/json")
    public ResponseEntity<ItemDTO> add(@RequestBody ItemDTO item){
        Item item1 = ItemMapper.map(item);
        itemRepositoryJpa.saveAndFlush(item1);
        return ResponseEntity.ok(item);
    }

    @GetMapping("get/")
    public ItemDTO get(){
        ItemDTO item = new ItemDTO(new BigDecimal("200"), new LinkedHashSet<>(Arrays.asList(28,29)), new LinkedHashSet<>(Arrays.asList(30,31)), "Książka o Javie", new Stock(12));
        //BigDecimal basicPrice, Category category, List<Tag> tags, String name, Stock stock)
        item.setDiscount(new Discount(5, new BigDecimal(20)));
        return item;
    }

    @GetMapping("getAll/")
    public List<Item> getAll(){
        return itemRepositoryJpa.findAll();
    }

    @Transactional
    @GetMapping(value = "delete/", params = "name")
    public void delete(@RequestParam String name){
        Item item = itemRepositoryJpa.getItemByName(name);
        itemRepositoryJpa.delete(item);
    }
}
