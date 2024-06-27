package com.bookstoremanagementsystem.controller;

import java.util.*; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookstoremanagementsystem.entity.Book;
import com.bookstoremanagementsystem.entity.MyBookList;
import com.bookstoremanagementsystem.service.BookService;
import com.bookstoremanagementsystem.service.MyBookListService;

@Controller
public class BookController
{
	@Autowired
	private BookService service;
	

	@Autowired
	private MyBookListService myBookService;
	
	@GetMapping("/")//request - pATH
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister()
	{
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook()
	{
		List<Book> list=service.getAllBook();
		/*
		 * ModelAndView view=ModelAndView();
		 *  m.setViewName("bookList");
		 * m.addObject("book",list);
		 */
		return new ModelAndView("bookList","book",list);
	}
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b)
	{
		service.save(b);
		return "redirect:/available_books";
	}
	

	@GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
		List<MyBookList>list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
		
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id)
	{
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice(),b.getQuantity());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
		
	}
}
