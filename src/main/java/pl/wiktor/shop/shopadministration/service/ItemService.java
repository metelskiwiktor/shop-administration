package pl.wiktor.shop.shopadministration.service;

import pl.wiktor.shop.shopadministration.model.dto.request.ItemDTO;
import pl.wiktor.shop.shopadministration.model.entity.Item;

import java.util.List;

public interface ItemService {
    void add(ItemDTO itemDTO);
    void edit(int idOldItem, ItemDTO itemDTO);
    void delete(int id);
    List<Item> getAll();
}
