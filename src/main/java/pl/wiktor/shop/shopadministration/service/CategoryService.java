package pl.wiktor.shop.shopadministration.service;

import pl.wiktor.shop.shopadministration.model.dto.request.EditCategoryRequestDTO;
import pl.wiktor.shop.shopadministration.model.entity.Category;

public interface CategoryService {
    void addCategory(Category category);
    void editCategory(EditCategoryRequestDTO editCategoryRequestDTO);
}
