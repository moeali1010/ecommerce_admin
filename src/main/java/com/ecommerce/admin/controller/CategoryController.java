package com.ecommerce.admin.controller;

import com.ecommerce.admin.dto.CategoryDTO;
import com.ecommerce.admin.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    //    // Get all categories
    //    @GetMapping
    //    public List<Category> getAllCategories() {
    //        return categoryService.getAllCategories();
    //    }
    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    //    // Get category by ID
    //    @GetMapping("/{id}")
    //    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
    //        return categoryService.getCategoryById(id)
    //                .map(ResponseEntity::ok)
    //                .orElse(ResponseEntity.notFound().build());
    //    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //    // Create new category
    //    @PostMapping
    //    public Category createCategory(@RequestBody Category category) {
    //        return categoryService.createCategory(category);
    //    }
    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    //    // Update category
    //    @PutMapping("/{id}")
    //    public ResponseEntity<Category> updateCategory(
    //            @PathVariable Long id,
    //            @RequestBody Category categoryDetails) {
    //        return ResponseEntity.ok(categoryService.updateCategory(id, categoryDetails));
    //    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryDTO));
    }

    //    // Delete category
    //    @DeleteMapping("/{id}")
    //    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
    //        categoryService.deleteCategory(id);
    //        return ResponseEntity.noContent().build();
    //    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
