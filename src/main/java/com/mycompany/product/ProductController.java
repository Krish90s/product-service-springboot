package com.mycompany.product;


import com.mycompany.product.dtos.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductEntity> getAllProduct(){
        return productService.getAllProducts();
    }

    @PostMapping
    public ProductEntity getAllProduct(@RequestBody CreateProductRequest requestBody){
        return productService.createProduct(requestBody);
    }
}
