package pl.wiktor.shop.shopadministration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wiktor.shop.shopadministration.model.entity.Category;

import java.util.Optional;

public interface CategoryRepositoryJpa extends JpaRepository<Category, Integer> {
    Optional<Boolean> existsCategoryByName(String name);
    Category getCategoryByName(String name);
}
