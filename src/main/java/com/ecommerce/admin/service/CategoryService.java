

package com.ecommerce.admin.service;

import com.ecommerce.admin.dto.CategoryDTO;
import com.ecommerce.admin.entity.Category;
import com.ecommerce.admin.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    //    public List<Category> getAllCategories() {
    //        return  categoryRepository.findAll();
    //    }
    //
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(cat -> new CategoryDTO(cat.getId(), cat.getName()))
                .collect(Collectors.toList());
    }


    //    public Optional<Category> getCategoryById(Long id) {
    //        return  categoryRepository.findById(id);
    //    }
    public Optional<CategoryDTO> getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(cat -> new CategoryDTO(cat.getId(), cat.getName()));
    }


    //    public Category createCategory( Category category ){
    //        return  categoryRepository.save(category);
    //    }
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO.getName());
        Category savedCategory = categoryRepository.save(category);
        return new CategoryDTO(savedCategory.getId(), savedCategory.getName());
    }



    //    public Category updateCategory(Long id, Category categoryDetails) {
    //        Category category = categoryRepository.findById(id)
    //                .orElseThrow(() -> new RuntimeException("Category not found"));
    //
    //        category.setName(categoryDetails.getName());
    //        return categoryRepository.save(category);
    //    }
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(categoryDTO.getName());
        Category updatedCategory = categoryRepository.save(category);
        return new CategoryDTO(updatedCategory.getId(), updatedCategory.getName());
    }

    //    public void deleteCategory(Long id){
    //        this.categoryRepository.deleteById(id);
    //    }
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
