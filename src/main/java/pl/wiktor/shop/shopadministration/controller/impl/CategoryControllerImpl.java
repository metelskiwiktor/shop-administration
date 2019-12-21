package pl.wiktor.shop.shopadministration.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wiktor.shop.shopadministration.model.dto.request.EditCategoryRequestDTO;
import pl.wiktor.shop.shopadministration.model.entity.Category;
import pl.wiktor.shop.shopadministration.service.CategoryService;

@RestController()
@RequestMapping("category/")
public class CategoryControllerImpl {
    private final String ADD = "add/";
    private final String EDIT = "edit/";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private CategoryService categoryService;


    @Autowired
    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = ADD, params = "name")
    public void addCategory(@RequestParam(value = "name") String name){
        logger.info("Trying to add category = '{}'", name);
        categoryService.addCategory(new Category(name));
    }

    @PostMapping(value = EDIT, consumes = "application/json")
    public void editCategory(@RequestBody EditCategoryRequestDTO editCategoryRequestDTO){
        logger.info("Trying to edit category, old category = '{}', new category = '{}'",
                editCategoryRequestDTO.getOldNameCategory(),
                editCategoryRequestDTO.getNewNameCategory()
        );
        categoryService.editCategory(editCategoryRequestDTO);
    }

}
