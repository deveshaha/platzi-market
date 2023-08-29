package com.platzi.market.domain.service;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repo.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAllPurchases(){
        return purchaseRepository.getAllPurchases();
    }

    public Optional<List<Purchase>> getPurchaseByClient(String clientId){
        return purchaseRepository.getPurchaseByClient(clientId);
    }

    public Purchase savePurchase(Purchase purchase) {
        return purchaseRepository.savePurchase(purchase);
    }

}
