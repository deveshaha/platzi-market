package com.platzi.market.domain.repo;

import com.platzi.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAllPurchases();
    Optional<List<Purchase>> getPurchaseByClient(String clientId);
    Purchase savePurchase(Purchase purchase);

}
