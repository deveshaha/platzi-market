package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public Optional<Product> getProductById(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getProductByCategory(int productId) {
        return productRepository.getProductByCategory(productId);
    }

    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    public boolean deleteProduct(int productId) {
        if (getProductById(productId).isPresent()) {
            productRepository.delete(productId);
            return true;
        } else {
            return false;
        }
    }

}
