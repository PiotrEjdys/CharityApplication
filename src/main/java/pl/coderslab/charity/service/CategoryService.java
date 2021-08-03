package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Category;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(long id);

    void addCategory(Category category);

    void deleteCategoryById(long id);

    void updateCategory(Category category);

}
