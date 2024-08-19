package com.bookStoreManagementSystemApp.service;


import com.bookStoreManagementSystemApp.dto.ShopkeeperDTO;

import java.util.List;

public interface ShopkeeperService {
    ShopkeeperDTO createShopkeeper(ShopkeeperDTO shopkeeperDTO);
    ShopkeeperDTO getShopkeeperById(Long id);
    List<ShopkeeperDTO> getAllShopkeepers();
    ShopkeeperDTO updateShopkeeper(Long id, ShopkeeperDTO shopkeeperDTO);
    void deleteShopkeeper(Long id);
}
