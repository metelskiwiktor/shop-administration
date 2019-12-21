package pl.wiktor.shop.shopadministration.service.impl;

import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import pl.wiktor.shop.shopadministration.exception.InvalidCategoryNameException;
import pl.wiktor.shop.shopadministration.model.dto.request.CategoryDTO;
import pl.wiktor.shop.shopadministration.model.dto.request.EditCategoryRequestDTO;
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

    public void edit(String oldCategory, CategoryDTO categoryDTO) throws NullPointerException{
        Category category = categoryRepository.getCategoryByName(oldCategory);
        category.setName(categoryDTO.getName());
        categoryRepository.saveAndFlush(category);
    }

    public void delete(String name) throws IllegalArgumentException{
        Category category = categoryRepository.getCategoryByName(name);
        categoryRepository.delete(category);
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

}

