package com.example.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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

	    //Entity轉換成BookVo的方法
	    public BookVo ConverToVo(BookEntity e) {
	        BookVo vo = new BookVo();
	        vo.setID(e.getID());
	        vo.setName(e.getName());
	        vo.setAuthor(e.getAuthor());
	        return vo;
	    }
	    //列舉所有的書的方法
	    public List<BookVo> getAllBook() {
			List<BookEntity> books = Bookrepo.findAll();
		 return books.stream().map(e-> ConverToVo(e)).collect(Collectors.toList());
		}
	    
	    //建立新的Entity物件並存進DB
	   public void  InserBooks(BookVo vo) {
		   BookEntity entity = new BookEntity();
		  entity.setID(vo.getID());
		  entity.setName(vo.getName());
		  entity.setAuthor(vo.getAuthor());
		  entity.setBuydate(parseDate(vo.getBuydate()));
		  entity.setImage("AAA");
		  Bookrepo.save(entity);
	   }
	   
	   //把BookVo的Buydate的型別String，型別轉換成Date
	   public Date parseDate(String dueDateStr) {
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            return formatter.parse(dueDateStr);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
		}
	
}	

