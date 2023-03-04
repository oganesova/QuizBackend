package com.quizz.quizPortal.controller;

import com.quizz.quizPortal.entity.Category;
import com.quizz.quizPortal.entity.Quiz;
import com.quizz.quizPortal.repository.CategoryRepository;
import com.quizz.quizPortal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId) {
        return this.categoryService.getCategory(categoryId);
    }
    @PostMapping("/save")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(this.categoryService.saveCategory(category));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }
    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        return ResponseEntity.ok(this.categoryService.updateCategory(category));
    }
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId")Long categoryId){
        this.categoryService.deleteCategory(categoryId);
    }
    /*@PutMapping("/{cId}")
    public ResponseEntity<Category> updateCategory(@PathVariable("cId") Long cId,@RequestBody Category category) throws Exception {
        Category newCategory = categoryRepository.findById(cId)
                .orElseThrow(() -> new Exception("Category not exist with id: " + cId));

        newCategory.setTitle(category.getTitle());
        newCategory.setDescription(category.getDescription());

        categoryRepository.save(newCategory);

        return ResponseEntity.ok(newCategory);

    }*/

}

