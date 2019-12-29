package pl.wiktor.shop.shopadministration.model.mapper;

import pl.wiktor.shop.shopadministration.model.dto.request.ItemDTO;
import pl.wiktor.shop.shopadministration.model.entity.Item;

public abstract class ItemMapper {
    public static Item map(ItemDTO itemDTO){
        Item item = new Item();
        item.setAuthors(itemDTO.getAuthors());
        item.setBasicPrice(itemDTO.getBasicPrice());
        item.setCategories(itemDTO.getCategories());
        item.setDiscount(itemDTO.getDiscount());
        item.setId(itemDTO.getId());
        item.setName(itemDTO.getName());
        item.setStock(itemDTO.getStock());
        item.setTags(itemDTO.getTags());

        return item;
    }
}
