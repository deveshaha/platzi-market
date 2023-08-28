package com.platzi.market.domain.repo;

import com.platzi.market.domain.Product;
import com.platzi.market.persistance.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getAllProducts();
    Optional<List<Product>> getProductByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product saveProduct(Product product);
    void delete(int productId);
}