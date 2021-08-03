package pl.coderslab.charity.repository;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.service.CategoryService;

import java.util.List;
@Service
public class JpaCategoryRepository implements CategoryService {

    private final CategoryRepository repository;

    public JpaCategoryRepository(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        return repository.getCategoryById(id);
    }

    @Override
    public void addCategory(Category category) {
        repository.save(category);
    }

    @Override
    public void deleteCategoryById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateCategory(Category category) {
        repository.save(category);
    }
}
