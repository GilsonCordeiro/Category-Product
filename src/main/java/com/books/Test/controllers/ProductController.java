package com.books.Test.controllers;

import com.books.Test.model.Product;
import com.books.Test.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository repository;
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> result = repository.findAll();
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> finById(@Valid @PathVariable Long id){
        Optional<Product> result = repository.findById(id);
        return ResponseEntity.ok().body(result);
    }
    @PostMapping
    public ResponseEntity<Product> insert(@Valid @RequestBody Product product){
        Product result = repository.save(product);
        return ResponseEntity.ok().body(result);
    }
}
