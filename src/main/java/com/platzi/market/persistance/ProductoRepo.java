package com.platzi.market.persistance;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repo.ProductRepository;
import com.platzi.market.persistance.crud.ProductoCrudRepo;
import com.platzi.market.persistance.entity.Producto;
import com.platzi.market.persistance.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Se utiliza esta anotacion por que esta clase está interactuando con la base de datos
public class ProductoRepo implements ProductRepository {

    @Autowired
    private ProductoCrudRepo productoCrudRepo;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAllProducts() {
        List<Producto> productos = (List<Producto>)  productoCrudRepo.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getProductByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepo.findByCategoria_IdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepo.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepo.findById(productId).map(producto -> productMapper.toProduct(producto));
    }

    @Override
    public Product saveProduct(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepo.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepo.deleteById(productId);
    }

    /*

    public List<Producto> getProductoByCategoria(int idCategoria) {
        return productoCrudRepo.findByIdCategoriaAsc(idCategoria);
    }

    public Optional<List<Producto>> getProductosEscasos(int cantidad) {
        return productoCrudRepo.findByCantidadStockLessThanAndEstado(cantidad,true);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepo.findById(idProducto);
    }

    public Producto saveProduct(Producto producto) {
        return productoCrudRepo.save(producto);
    }

    public void deleteProductById(int idProducto) {
        productoCrudRepo.deleteById(idProducto);
    }

     */
}
