package pl.wiktor.shop.shopadministration.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wiktor.shop.shopadministration.controller.CategoryController;
import pl.wiktor.shop.shopadministration.model.dto.request.CategoryDTO;
import pl.wiktor.shop.shopadministration.model.dto.request.EditCategoryRequestDTO;
import pl.wiktor.shop.shopadministration.model.entity.Category;
import pl.wiktor.shop.shopadministration.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping(CategoryControllerImpl.CATEGORY)
public class CategoryControllerImpl implements CategoryController {
    public static final String CATEGORY = "category/";
    public static final String DELETE = "delete/";
    public static final String ADD = "add/";
    public static final String EDIT = "edit/";
    public static final String NAME = "name/";
    public static final String GET_ALL = "getAll/";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private CategoryService categoryService;


    @Autowired
    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = ADD, consumes = "application/json")
    public ResponseEntity<String> addCategory(@RequestBody CategoryDTO categoryDTO){
        logger.info("Trying to add category = '{}'", categoryDTO);

        categoryService.add(categoryDTO);

        logger.info("Category successful added");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = EDIT+"{oldCategory}", consumes = "application/json")
    public ResponseEntity<String>  editCategory(@PathVariable String oldCategory, @RequestBody CategoryDTO categoryDTO){
        logger.info("Trying to edit category, old category = '{}', new category = '{}'",
                oldCategory,
                categoryDTO.getName()
        );

        categoryService.edit(oldCategory, categoryDTO);

        logger.info("Category from name = '{}' successfully changed to name = '{}'",
                oldCategory,
                categoryDTO.getName()
        );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = DELETE+NAME)
    public ResponseEntity<String> deleteCategory(@PathVariable String name){
        logger.info("Trying to delete category = '{}'", name);

        categoryService.delete(name);

        logger.info("Successful deleted category = '{}'", name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = GET_ALL)
    public ResponseEntity<List<Category>> getAll(){
        logger.info("Trying to get all categories");

        List<Category> all = categoryService.getAll();

        logger.info("Successful got all categories");
        return ResponseEntity.ok(all);
    }
}
