package pl.wiktor.shop.shopadministration.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wiktor.shop.shopadministration.exception.InvalidCategoryNameException;
import pl.wiktor.shop.shopadministration.model.dto.request.EditCategoryRequestDTO;
import pl.wiktor.shop.shopadministration.model.entity.Category;
import pl.wiktor.shop.shopadministration.repository.CategoryRepositoryJpa;
import pl.wiktor.shop.shopadministration.service.CategoryService;

import javax.transaction.Transactional;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepositoryJpa categoryRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CategoryServiceImpl(CategoryRepositoryJpa categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(Category category) {
        categoryRepository.existsCategoryByName(category.getName()).filter($ -> !$).orElseThrow(InvalidCategoryNameException::new);
        categoryRepository.save(category);
        logger.info("Category successful added");
    }

    public void editCategory(EditCategoryRequestDTO editCategoryRequestDTO) {
        categoryRepository.existsCategoryByName(editCategoryRequestDTO.getOldNameCategory()).filter($ -> $).orElseThrow(InvalidCategoryNameException::new);
        Category category = categoryRepository.getCategoryByName(editCategoryRequestDTO.getOldNameCategory());
        category.setName(editCategoryRequestDTO.getNewNameCategory());
        categoryRepository.saveAndFlush(category);
        logger.info("Category from name = '{}' successfully changed to name = '{}'",
                editCategoryRequestDTO.getOldNameCategory(),
                editCategoryRequestDTO.getNewNameCategory()
        );
    }

}

