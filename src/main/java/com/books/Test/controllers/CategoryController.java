package com.books.Test.controllers;

import com.books.Test.model.Category;
import com.books.Test.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepository repository;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> result = repository.findAll();
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable Long id){
        Optional<Category> result = repository.findById(id);
        return ResponseEntity.ok().body(result);
    }
    @PostMapping
    public ResponseEntity<Category> insert(@Valid  @RequestBody Category category){
        Category result = repository.save(category);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        repository.deleteById(id);
    }

}
