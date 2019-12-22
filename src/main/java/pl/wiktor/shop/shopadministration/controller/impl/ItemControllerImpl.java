package pl.wiktor.shop.shopadministration.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wiktor.shop.shopadministration.model.entity.Discount;
import pl.wiktor.shop.shopadministration.model.entity.Item;
import pl.wiktor.shop.shopadministration.model.entity.Stock;
import pl.wiktor.shop.shopadministration.model.entity.Tag;
import pl.wiktor.shop.shopadministration.model.entity.Category;
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
    public void add(@RequestBody Item item){
//        item.setCategory(categoryRepositoryJpa.getCategoryByName(item.getCategory().getName()));
//        Set<Tag> tags = new HashSet<>();
//        item.getTags().forEach( tag -> tags.add(tagRepositoryJpa.getTagByName(tag.getName())));
//        item.setTags(tags);
        itemRepositoryJpa.saveAndFlush(item);
    }

    @GetMapping("get/")
    public Item get(){
        Item item = new Item(new BigDecimal("200"), new Category("programowanie w Java"), new HashSet<>(Arrays.asList(new Tag("Java"), new Tag("SQL"))), "Książka o Javie", new Stock(12));
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
