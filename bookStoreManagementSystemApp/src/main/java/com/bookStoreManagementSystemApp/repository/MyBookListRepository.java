package com.bookStoreManagementSystemApp.repository;

import com.bookStoreManagementSystemApp.entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookListRepository extends JpaRepository<MyBookList, Long> {
}
