package com.example.SBDemo1.services;

import com.example.SBDemo1.exceptions.ProductNotFoundException;
import com.example.SBDemo1.models.Product;

public interface ProductService {

    public Product gerProductById(long id) throws ProductNotFoundException;
}
