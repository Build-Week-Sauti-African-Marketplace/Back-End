package local.tyler.africanmarketplace.controllers;

import local.tyler.africanmarketplace.models.Category;
import local.tyler.africanmarketplace.models.Currency;
import local.tyler.africanmarketplace.services.CategoryService;
import local.tyler.africanmarketplace.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/categories")
    public ResponseEntity<?> listAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

}
