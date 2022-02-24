package com.books.Test.services;

import com.books.Test.model.Product;
import com.books.Test.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {
    @Autowired
    ProductRepository repository;

}
