package com.mycompany.product;

import com.mycompany.product.dtos.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;

    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    public ProductEntity createProduct(CreateProductRequest requestBody){
        ProductEntity newProduct = ProductEntity.builder()
                .firstName(requestBody.getFirstName())
                .lastName(requestBody.getLastName())
                .email(requestBody.getEmail())
                .build();

        return productRepository.save(newProduct);
    }
}
