package pl.wiktor.shop.shopadministration.service;

import org.springframework.dao.DataIntegrityViolationException;
import pl.wiktor.shop.shopadministration.model.dto.request.TagDTO;
import pl.wiktor.shop.shopadministration.model.entity.Tag;

import java.util.List;

public interface TagService {
    void add(TagDTO tagDTO);
    void delete(int id);
    List<Tag> getAll();
}
