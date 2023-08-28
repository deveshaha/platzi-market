package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/{productId}")
    public Optional<Product> getProductById(@PathVariable("productId") int productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getProductByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getProductByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/delete/{productId}")
    public boolean deleteProduct(@PathVariable("productId") int productId) {
        return productService.deleteProduct(productId);
    }
}
