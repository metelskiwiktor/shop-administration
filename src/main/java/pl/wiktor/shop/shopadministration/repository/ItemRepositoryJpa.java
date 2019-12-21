package pl.wiktor.shop.shopadministration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wiktor.shop.shopadministration.model.entity.Item;

public interface ItemRepositoryJpa extends JpaRepository<Item, Integer> {
    Item getItemByName(String name);
}
