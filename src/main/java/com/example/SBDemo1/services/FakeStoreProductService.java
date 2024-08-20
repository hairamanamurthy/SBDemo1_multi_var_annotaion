package com.example.SBDemo1.services;

import com.example.SBDemo1.dtos.FakeStoreProductDto;
import com.example.SBDemo1.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{

    @Override
    public Product gerProductById(long id) {
        /* take the id from  the input and call this endpoint:a
         https://fakestoreapi.com/products/20
         */
        String url="https://fakestoreapi.com/products/20";
        RestTemplate restTemplate=new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto=restTemplate.getForObject(url, FakeStoreProductDto.class);
        return convertFaakeStoreProductToProduct(fakeStoreProductDto);
    }
    private Product convertFaakeStoreProductToProduct(FakeStoreProductDto dto){
        Product product=new Product();
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
        product.setName(dto.getTitle());
        return product;
    }
}
