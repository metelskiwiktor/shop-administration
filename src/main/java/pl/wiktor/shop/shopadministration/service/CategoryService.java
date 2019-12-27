package pl.wiktor.shop.shopadministration.service;

import pl.wiktor.shop.shopadministration.model.dto.request.CategoryDTO;
import pl.wiktor.shop.shopadministration.model.entity.Category;

import java.util.List;

public interface CategoryService {
    void add(CategoryDTO categoryDTO);
    void edit(int idOldCategory, CategoryDTO categoryDTO);
    void delete(int id);
    List<Category> getAll();
}
