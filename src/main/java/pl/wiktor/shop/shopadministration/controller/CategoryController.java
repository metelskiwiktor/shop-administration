package pl.wiktor.shop.shopadministration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pl.wiktor.shop.shopadministration.model.dto.request.CategoryDTO;
import pl.wiktor.shop.shopadministration.model.dto.request.EditCategoryRequestDTO;
import pl.wiktor.shop.shopadministration.model.entity.Category;

import java.util.List;

public interface CategoryController {
    ResponseEntity<String> add(CategoryDTO categoryDTO);
    ResponseEntity<String> update(int oldCategory, CategoryDTO categoryDTO);
    ResponseEntity<String> delete(int id);
    ResponseEntity<List<Category>> getAll();
}
