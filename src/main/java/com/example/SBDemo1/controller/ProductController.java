package com.example.SBDemo1.controller;

import com.example.SBDemo1.exceptions.ProductNotFoundException;
import com.example.SBDemo1.models.Product;
import com.example.SBDemo1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) throws ProductNotFoundException {
//        if(productId<1 || productId>20){
//            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
//        }
        Product product= productService.gerProductById(productId);
        return new ResponseEntity<>(product,HttpStatusCode.valueOf(200));
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> getProductNotFoundException(ProductNotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatusCode.valueOf(400));
    }
}
