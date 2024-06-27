package com.bookstoremanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoremanagementsystem.entity.MyBookList;
import com.bookstoremanagementsystem.repository.MyBookRepository;

@Service
public class MyBookListService 
{
	@Autowired
	private MyBookRepository myBook;
	
	public void saveMyBooks(MyBookList book)
	{
		myBook.save(book);
	}
	public  List<MyBookList> getAllMyBooks()
	{
		return myBook.findAll();
	}
	public void deleteById(int id)
	{
		myBook.deleteById(id);
	}
}
