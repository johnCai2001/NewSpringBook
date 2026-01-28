package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.BookEntity;
import com.example.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private  BookRepository Bookrepo;
	
    
	//去資料庫抓全部書籍資料，每一筆資料變成一個 BookEntity。把所有 Entity 裝成 List回傳
	public List<BookEntity> findAll(){
		return Bookrepo.findAll();
	}
}
