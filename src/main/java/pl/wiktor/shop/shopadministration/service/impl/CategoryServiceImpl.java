package pl.wiktor.shop.shopadministration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import pl.wiktor.shop.shopadministration.model.dto.request.CategoryDTO;
import pl.wiktor.shop.shopadministration.model.entity.Category;
import pl.wiktor.shop.shopadministration.model.mapper.CategoryMapper;
import pl.wiktor.shop.shopadministration.repository.CategoryRepositoryJpa;
import pl.wiktor.shop.shopadministration.service.CategoryService;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepositoryJpa categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepositoryJpa categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void add(CategoryDTO categoryDTO) throws IllegalArgumentException, DataIntegrityViolationException {
        Category category = CategoryMapper.map(categoryDTO);
        categoryRepository.save(category);
    }

    public void edit(int idOldCategory, CategoryDTO categoryDTO) throws NullPointerException{
        Category category = categoryRepository.getOne(idOldCategory);
        category.setName(categoryDTO.getName());
        categoryRepository.save(category);
    }

    public void delete(int id) throws EmptyResultDataAccessException {
        categoryRepository.deleteById(id);
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

}

