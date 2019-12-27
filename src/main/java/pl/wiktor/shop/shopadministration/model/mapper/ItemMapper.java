package pl.wiktor.shop.shopadministration.model.mapper;

import pl.wiktor.shop.shopadministration.model.dto.request.ItemDTO;
import pl.wiktor.shop.shopadministration.model.entity.Category;
import pl.wiktor.shop.shopadministration.model.entity.Item;
import pl.wiktor.shop.shopadministration.model.entity.Tag;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class ItemMapper {
    public static Item map(ItemDTO itemDTO){
        Item item = new Item();
        item.setBasicPrice(itemDTO.getBasicPrice());
        item.setDiscount(itemDTO.getDiscount());
        item.setStock(itemDTO.getStock());

        Set<Tag> tags = new LinkedHashSet<>();
        itemDTO.getIdTags().forEach(idTag -> {
            Tag tag = new Tag();
            tag.setId(idTag);
            tags.add(tag);
        });
        item.setTags(tags);

        Set<Category> categories = new LinkedHashSet<>();
        itemDTO.getIdCategories().forEach(idCategory -> {
            Category category = new Category();
            category.setId(idCategory);
            categories.add(category);
        });
        item.setCategories(categories);

        item.setName(itemDTO.getName());
        return item;
    }
}
