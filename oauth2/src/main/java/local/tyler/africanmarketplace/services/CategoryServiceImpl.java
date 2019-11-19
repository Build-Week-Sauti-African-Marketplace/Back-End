package local.tyler.africanmarketplace.services;

import local.tyler.africanmarketplace.models.Category;
import local.tyler.africanmarketplace.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().iterator().forEachRemaining(categories::add);
        return categories;
    }

    @Override
    public Category getCategoryByType(String type) {
        return categoryRepository.findByTypeIgnoreCase(type);
    }
}
