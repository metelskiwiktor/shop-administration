package pl.wiktor.shop.shopadministration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wiktor.shop.shopadministration.model.entity.Author;
import pl.wiktor.shop.shopadministration.model.entity.Item;

import java.util.List;

public interface AuthorRepositoryJpa extends JpaRepository<Author, Integer> {
//    List<Item> get
}
