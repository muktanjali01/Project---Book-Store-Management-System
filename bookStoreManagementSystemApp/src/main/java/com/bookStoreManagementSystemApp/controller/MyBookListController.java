package com.bookStoreManagementSystemApp.controller;


import com.bookStoreManagementSystemApp.entity.Book;
import com.bookStoreManagementSystemApp.entity.Customer;
import com.bookStoreManagementSystemApp.entity.MyBookList;
import com.bookStoreManagementSystemApp.service.BookService;
import com.bookStoreManagementSystemApp.service.CustomerService;
import com.bookStoreManagementSystemApp.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/my-book-lists")
public class MyBookListController {

    private final MyBookListService myBookListService;
    private final CustomerService customerService;
    private final BookService bookService;

    @Autowired
    public MyBookListController(MyBookListService myBookListService, CustomerService customerService, BookService bookService) {
        this.myBookListService = myBookListService;
        this.customerService = customerService;
        this.bookService = bookService;
    }

    
    @GetMapping
    public ResponseEntity<List<MyBookList>> getAllBookLists() {
        List<MyBookList> bookLists = myBookListService.getAllBookLists();
        return ResponseEntity.ok(bookLists);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<MyBookList> getBookListById(@PathVariable Long id) {
        MyBookList bookList = myBookListService.getBookListById(id);
        return ResponseEntity.ok(bookList);
    }

    
    @PostMapping("/{customerId}")
    public ResponseEntity<MyBookList> createBookList(@PathVariable Long customerId, @Validated @RequestBody MyBookList myBookList) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        myBookList.setCustomer(customer);
        MyBookList createdBookList = myBookListService.saveOrUpdateBookList(myBookList);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBookList);
    }

    
    @PostMapping("/{bookListId}/books/{bookId}")
    public ResponseEntity<MyBookList> addBookToList(@PathVariable Long bookListId, @PathVariable Long bookId) {
        MyBookList bookList = myBookListService.getBookListById(bookListId);
        Book book = bookService.getBookById(bookId);

        if (bookList == null || book == null) {
            return ResponseEntity.notFound().build();
        }

        bookList.addBook(book);
        MyBookList updatedBookList = myBookListService.saveOrUpdateBookList(bookList);
        return ResponseEntity.ok(updatedBookList);
    }

    @DeleteMapping("/{bookListId}/books/{bookId}")
    public ResponseEntity<MyBookList> removeBookFromList(@PathVariable Long bookListId, @PathVariable Long bookId) {
        MyBookList bookList = myBookListService.getBookListById(bookListId);
        Book book = bookService.getBookById(bookId);

        if (bookList == null || book == null) {
            return ResponseEntity.notFound().build();
        }

        bookList.removeBook(book);
        MyBookList updatedBookList = myBookListService.saveOrUpdateBookList(bookList);
        return ResponseEntity.ok(updatedBookList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookList(@PathVariable Long id) {
        myBookListService.deleteBookList(id);
        return ResponseEntity.noContent().build();
    }
}
