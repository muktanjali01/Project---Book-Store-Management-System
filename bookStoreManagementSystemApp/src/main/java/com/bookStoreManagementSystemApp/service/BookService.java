package com.bookStoreManagementSystemApp.service;


import com.bookStoreManagementSystemApp.dto.BookDTO;
import com.bookStoreManagementSystemApp.entity.Book;

import java.util.List;

public interface BookService {
    BookDTO createBook(BookDTO bookDTO);
    BookDTO getBookById(Long id);
    List<BookDTO> getAllBooks();
    BookDTO updateBook(Long id, BookDTO bookDTO);
    void deleteBook(Long id);
}
