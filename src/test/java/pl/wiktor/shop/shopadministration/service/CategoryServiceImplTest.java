package pl.wiktor.shop.shopadministration.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.wiktor.shop.shopadministration.model.dto.request.CategoryDTO;
import pl.wiktor.shop.shopadministration.model.entity.Category;
import pl.wiktor.shop.shopadministration.repository.CategoryRepositoryJpa;
import pl.wiktor.shop.shopadministration.service.impl.CategoryServiceImpl;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest {

    @Mock
    private CategoryRepositoryJpa categoryRepositoryJpa;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private Category category;
    private CategoryDTO categoryDTO;

    @Before
    public void setUp() throws Exception {
        category = new Category("category");
        categoryDTO = new CategoryDTO(0, "category");
    }

    @Test
    public void add(){
        categoryService.add(categoryDTO);
        verify(categoryRepositoryJpa, times(1)).save(any());
    }

    public void edit(){
        String oldCategory = null;
        categoryService.edit(oldCategory, categoryDTO);
    }
}
