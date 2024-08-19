package com.bookStoreManagementSystemApp.service;


import com.bookStoreManagementSystemApp.dto.MyBookListDTO;
import com.bookStoreManagementSystemApp.entity.MyBookList;

import java.util.List;

public interface MyBookListService {
    MyBookListDTO createMyBookList(MyBookListDTO myBookListDTO);
    MyBookListDTO getMyBookListById(Long id);
    List<MyBookListDTO> getAllMyBookLists();
    MyBookListDTO updateMyBookList(Long id, MyBookListDTO myBookListDTO);
    void deleteMyBookList(Long id);
}

