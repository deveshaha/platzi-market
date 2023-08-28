package com.platzi.market.persistance.crud;

import com.platzi.market.persistance.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepo extends CrudRepository<Producto, Integer> {

    /*
    Las queries tambien se pueden hacer de manera nativa, ejemplo:
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
     */
    List<Producto> findByCategoria_IdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
