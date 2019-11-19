package local.tyler.africanmarketplace.services;

import local.tyler.africanmarketplace.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryByType(String type);
}
