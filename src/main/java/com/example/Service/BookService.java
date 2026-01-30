package com.example.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
	
	//要編輯某一本書 → 你一定要知道「是哪一本」。而「哪一本」的唯一識別就是 ID。
	public BookVo getBookById(Long id) {
	 BookEntity Entity = Bookrepo.findById(id).orElse(null);
	 return ConverToVo(Entity);
	}
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
	   //刪除資料
	   public void DeleteBooksById(Long ID) {
		   Bookrepo.deleteById(ID);
	   }
	   
	public void  updateBooks(BookVo vo) {
		BookEntity entity = Bookrepo.findById(vo.getID()).orElse(null);
		if (!vo.getName().isBlank()) {
			entity.setName(vo.getName());
		}
		if (!vo.getAuthor().isBlank()) {
			entity.setAuthor(vo.getAuthor());
		}
		Bookrepo.save(entity);
	      }
       }


