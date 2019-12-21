package pl.wiktor.shop.shopadministration.model.mapper;

import pl.wiktor.shop.shopadministration.model.dto.request.CategoryDTO;
import pl.wiktor.shop.shopadministration.model.entity.Category;

public abstract class CategoryMapper {
    public static Category map(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return category;
    }
}
