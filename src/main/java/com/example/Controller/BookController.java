package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.Service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookservice;

}
