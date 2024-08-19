package com.bookStoreManagementSystemApp.controller;


import com.bookStoreManagementSystemApp.entity.Shopkeeper;
import com.bookStoreManagementSystemApp.service.ShopkeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopkeepers")
public class ShopkeeperController {

    private final ShopkeeperService shopkeeperService;

    @Autowired
    public ShopkeeperController(ShopkeeperService shopkeeperService) {
        this.shopkeeperService = shopkeeperService;
    }

  
    @GetMapping
    public ResponseEntity<List<Shopkeeper>> getAllShopkeepers() {
        List<Shopkeeper> shopkeepers = shopkeeperService.getAllShopkeepers();
        return ResponseEntity.ok(shopkeepers);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Shopkeeper> getShopkeeperById(@PathVariable Long id) {
        Shopkeeper shopkeeper = shopkeeperService.getShopkeeperById(id);
        return ResponseEntity.ok(shopkeeper);
    }

    
    @PostMapping
    public ResponseEntity<Shopkeeper> createShopkeeper(@Validated @RequestBody Shopkeeper shopkeeper) {
        Shopkeeper createdShopkeeper = shopkeeperService.saveOrUpdateShopkeeper(shopkeeper);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShopkeeper);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Shopkeeper> updateShopkeeper(@PathVariable Long id, @Validated @RequestBody Shopkeeper shopkeeperDetails) {
        Shopkeeper updatedShopkeeper = shopkeeperService.updateShopkeeper(id, shopkeeperDetails);
        return ResponseEntity.ok(updatedShopkeeper);
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShopkeeper(@PathVariable Long id) {
        shopkeeperService.deleteShopkeeper(id);
        return ResponseEntity.noContent().build();
    }
}
