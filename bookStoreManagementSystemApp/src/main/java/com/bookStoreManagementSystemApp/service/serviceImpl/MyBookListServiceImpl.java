package com.bookStoreManagementSystemApp.service.serviceImpl;

import com.bookStoreManagementSystemApp.dto.MyBookListDTO;
import com.bookStoreManagementSystemApp.entity.MyBookList;
import com.bookStoreManagementSystemApp.repository.MyBookListRepository;
import com.bookStoreManagementSystemApp.service.MyBookListService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyBookListServiceImpl implements MyBookListService {

    @Autowired
    private MyBookListRepository myBookListRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MyBookListDTO createMyBookList(MyBookListDTO myBookListDTO) {
        MyBookList myBookList = modelMapper.map(myBookListDTO, MyBookList.class);
        MyBookList savedMyBookList = myBookListRepository.save(myBookList);
        return modelMapper.map(savedMyBookList, MyBookListDTO.class);
    }

    @Override
    public MyBookListDTO getMyBookListById(Long id) {
        MyBookList myBookList = myBookListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MyBookList not found with id " + id));
        return modelMapper.map(myBookList, MyBookListDTO.class);
    }

    @Override
    public List<MyBookListDTO> getAllMyBookLists() {
        List<MyBookList> myBookLists = myBookListRepository.findAll();
        return myBookLists.stream()
                .map(myBookList -> modelMapper.map(myBookList, MyBookListDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MyBookListDTO updateMyBookList(Long id, MyBookListDTO myBookListDTO) {
        MyBookList myBookList = myBookListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MyBookList not found with id " + id));

        myBookList.setCustomer(myBookListDTO.getCustomer());
        myBookList.setBooks(myBookListDTO.getBooks());
        myBookList.setName(myBookListDTO.getName());

        MyBookList updatedMyBookList = myBookListRepository.save(myBookList);
        return modelMapper.map(updatedMyBookList, MyBookListDTO.class);
    }

    @Override
    public void deleteMyBookList(Long id) {
        MyBookList myBookList = myBookListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MyBookList not found with id " + id));
        myBookListRepository.delete(myBookList);
    }
}
