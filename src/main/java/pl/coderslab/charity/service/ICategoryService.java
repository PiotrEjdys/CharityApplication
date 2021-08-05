package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Category;

import java.util.List;


public interface ICategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(long id);

    void addCategory(Category category);

    void deleteCategoryById(long id);

    void updateCategory(Category category);

}
