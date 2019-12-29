package pl.wiktor.shop.shopadministration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import pl.wiktor.shop.shopadministration.model.dto.request.CategoryDTO;
import pl.wiktor.shop.shopadministration.model.dto.request.TagDTO;
import pl.wiktor.shop.shopadministration.model.entity.Category;
import pl.wiktor.shop.shopadministration.model.entity.Tag;
import pl.wiktor.shop.shopadministration.model.mapper.CategoryMapper;
import pl.wiktor.shop.shopadministration.model.mapper.TagMapper;
import pl.wiktor.shop.shopadministration.repository.TagRepositoryJpa;
import pl.wiktor.shop.shopadministration.service.TagService;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private TagRepositoryJpa tagRepository;

    @Autowired
    public TagServiceImpl(TagRepositoryJpa tagRepository) {
        this.tagRepository = tagRepository;
    }

    public void add(TagDTO tagDTO) throws IllegalArgumentException, DataIntegrityViolationException {
        Tag tag = TagMapper.map(tagDTO);
        tagRepository.save(tag);
    }

    public void delete(int id) throws EmptyResultDataAccessException {
        tagRepository.deleteById(id);
    }

    public List<Tag> getAll(){
        return tagRepository.findAll();
    }
}
