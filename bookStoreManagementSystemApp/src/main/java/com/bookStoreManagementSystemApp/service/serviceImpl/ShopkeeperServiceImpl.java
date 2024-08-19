package com.bookStoreManagementSystemApp.service.serviceImpl;


import com.bookStoreManagementSystemApp.dto.ShopkeeperDTO;
import com.bookStoreManagementSystemApp.entity.Shopkeeper;
import com.bookStoreManagementSystemApp.repository.ShopkeeperRepository;
import com.bookStoreManagementSystemApp.service.ShopkeeperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopkeeperServiceImpl implements ShopkeeperService {

    @Autowired
    private ShopkeeperRepository shopkeeperRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ShopkeeperDTO createShopkeeper(ShopkeeperDTO shopkeeperDTO) {
        Shopkeeper shopkeeper = modelMapper.map(shopkeeperDTO, Shopkeeper.class);
        Shopkeeper savedShopkeeper = shopkeeperRepository.save(shopkeeper);
        return modelMapper.map(savedShopkeeper, ShopkeeperDTO.class);
    }

    @Override
    public ShopkeeperDTO getShopkeeperById(Long id) {
        Shopkeeper shopkeeper = shopkeeperRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shopkeeper not found with id " + id));
        return modelMapper.map(shopkeeper, ShopkeeperDTO.class);
    }

    @Override
    public List<ShopkeeperDTO> getAllShopkeepers() {
        List<Shopkeeper> shopkeepers = shopkeeperRepository.findAll();
        return shopkeepers.stream()
                .map(shopkeeper -> modelMapper.map(shopkeeper, ShopkeeperDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ShopkeeperDTO updateShopkeeper(Long id, ShopkeeperDTO shopkeeperDTO) {
        Shopkeeper shopkeeper = shopkeeperRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shopkeeper not found with id " + id));

        shopkeeper.setName(shopkeeperDTO.getName());
        shopkeeper.setEmail(shopkeeperDTO.getEmail());
        shopkeeper.setPhoneNumber(shopkeeperDTO.getPhoneNumber());
        shopkeeper.setAddress(shopkeeperDTO.getAddress());

        Shopkeeper updatedShopkeeper = shopkeeperRepository.save(shopkeeper);
        return modelMapper.map(updatedShopkeeper, ShopkeeperDTO.class);
    }

    @Override
    public void deleteShopkeeper(Long id) {
        Shopkeeper shopkeeper = shopkeeperRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shopkeeper not found with id " + id));
        shopkeeperRepository.delete(shopkeeper);
    }
}

