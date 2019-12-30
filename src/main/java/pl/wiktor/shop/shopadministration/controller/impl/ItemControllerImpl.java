package pl.wiktor.shop.shopadministration.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wiktor.shop.shopadministration.controller.ItemController;
import pl.wiktor.shop.shopadministration.model.dto.request.CategoryDTO;
import pl.wiktor.shop.shopadministration.model.dto.request.ItemDTO;
import pl.wiktor.shop.shopadministration.model.entity.*;
import pl.wiktor.shop.shopadministration.service.ItemService;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping(ItemControllerImpl.ITEM)
public class ItemControllerImpl implements ItemController {
    public static final String ITEM = "/item";
    public static final String DELETE = "/delete";
    public static final String ADD = "/add";
    public static final String UPDATE = "/update";
    public static final String GET_ALL = "/getAll";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private ItemService itemService;

    @Autowired
    public ItemControllerImpl(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(value = ADD, consumes = "application/json")
    public ResponseEntity<ItemDTO> add(@RequestBody ItemDTO itemDTO){
        logger.info("Trying to add item = '{}'", itemDTO);

        itemService.add(itemDTO);

        logger.info("Item = '{}' successful added", itemDTO);
        return ResponseEntity.ok(itemDTO);
    }

    @GetMapping("/get")
    public ItemDTO get(){
        return new ItemDTO(
                new BigDecimal("200"),
                new Discount(5, new BigDecimal(20)),
                new LinkedHashSet<>(Collections.singletonList(new Category("programowanie w Java"))),
                new LinkedHashSet<>(Arrays.asList(new Tag("SQL"), new Tag("Java"))),
                "Książka o Javie",
                new Stock(12),
                new LinkedHashSet<>(Collections.singletonList(new Author("Robert C. Martin","O autorze")))
        );
    }

    @PutMapping(value = UPDATE + "{idOldItem}", consumes = "application/json")
    public ResponseEntity<String> update(@PathVariable int idOldItem, @RequestBody ItemDTO itemDTO) {
        logger.info("Trying to edit item, old item id = '{}', new item = '{}'",
                idOldItem,
                itemDTO.getName()
        );

        itemService.edit(idOldItem, itemDTO);

        logger.info("Item from id = '{}' successfully changed to = '{}'",
                idOldItem,
                itemDTO.getName()
        );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(GET_ALL)
    public List<Item> getAll(){
        return itemService.getAll();
    }

    @GetMapping(DELETE + "/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        logger.info("Trying to delete item, id = '{}'", id);

        itemService.delete(id);

        logger.info("Successful deleted item, id = '{}'", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
