package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.BookEntity;
import com.example.model.BookVo;
import com.example.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private  BookRepository Bookrepo;

	    // Entity轉換成BookVo
	    public BookVo ConverToVo(BookEntity e) {
	        BookVo vo = new BookVo();
	        vo.setID(e.getID());
	        vo.setName(e.getName());
	        vo.setAuthor(e.getAuthor());
	        return vo;
	    }
	    public List<BookVo> getAllBook() {
			List<BookEntity> books = Bookrepo.findAll();
		 return books.stream().map(e-> ConverToVo(e)).collect(Collectors.toList());
		}
	}

