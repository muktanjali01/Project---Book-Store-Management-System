package com.bookstoremanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {

	@RequestMapping("/deleteMyList/(id)")
	public String deleteMyList(@PathVariable("id")int id)
	{
		return null;
		
	}
}
