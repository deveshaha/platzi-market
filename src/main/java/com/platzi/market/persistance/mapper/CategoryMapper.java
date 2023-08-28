package com.platzi.market.persistance.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.domain.Product;
import com.platzi.market.persistance.entity.Categoria;
import com.platzi.market.persistance.entity.Producto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    @InheritConfiguration //Utilizamos esta anotacion para realizar un mapeo inverso al que ya tenemos, por lo que no hay que utilizar @mapping de nuevo
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
