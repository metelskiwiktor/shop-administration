package pl.wiktor.shop.shopadministration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wiktor.shop.shopadministration.model.entity.Tag;

public interface TagRepositoryJpa extends JpaRepository<Tag, Integer> {
    Tag getTagByName(String name);
}
