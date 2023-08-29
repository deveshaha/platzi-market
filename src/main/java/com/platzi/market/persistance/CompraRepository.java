package com.platzi.market.persistance;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repo.PurchaseRepository;
import com.platzi.market.persistance.crud.CompraCrudRepo;
import com.platzi.market.persistance.entity.Compra;
import com.platzi.market.persistance.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepo compraCrudRepo;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAllPurchases() {
        return mapper.toPurchases((List<Compra>) compraCrudRepo.findAll());
    }

    @Override
    public Optional<List<Purchase>> getPurchaseByClient(String clientId) {
        return compraCrudRepo.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase savePurchase(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return mapper.toPurchase(compraCrudRepo.save(compra));
    }
}
