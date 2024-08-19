package com.bookStoreManagementSystemApp.repository;

import com.bookStoreManagementSystemApp.entity.Shopkeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopkeeperRepository extends JpaRepository<Shopkeeper, Long> {
}
