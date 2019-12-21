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

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Transactional
@RestController
@RequestMapping("item/")
public class ItemControllerImpl {
    private ItemRepositoryJpa itemRepositoryJpa;
    private CategoryRepositoryJpa categoryRepositoryJpa;

    @Autowired
    public ItemControllerImpl(ItemRepositoryJpa itemRepositoryJpa, CategoryRepositoryJpa categoryRepositoryJpa) {
        this.itemRepositoryJpa = itemRepositoryJpa;
        this.categoryRepositoryJpa = categoryRepositoryJpa;
    }

    @Transactional
    @PostMapping(value = "add/", consumes = "application/json")
    public void add(@RequestBody Item item){
        itemRepositoryJpa.saveAndFlush(item);
    }

    @GetMapping("get/")
    public Item get(){
        Item item = new Item(new BigDecimal("200"), new Category("programowanie w Java"), Arrays.asList(new Tag("Java")), "Książka o Javie", new Stock(12));
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
