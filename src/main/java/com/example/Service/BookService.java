package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private  BookRepository Bookrepo;
	
}
