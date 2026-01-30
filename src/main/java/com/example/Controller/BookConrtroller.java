package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.BookVo;
import com.example.service.BookService;

@Controller
public class BookConrtroller {

	@Autowired
	private BookService bookservice;

	//Mapping中("/")是一開始連網址連上的初始路徑 Localhost:8080
	@GetMapping("/")
	public String Login() {
		System.out.println("Login Success");
		return "Login";
	}
	
	//呼叫 service 拿資料findAll()，放進 model並把要傳入的資料取名叫books，回傳要顯示的頁面名稱（View）
	@GetMapping("/books")
	public String GetAllbooks(Model model) {
		//BookVo沒辦法直接用BookEntity，所以要在Service用迴圈去轉換(getAllBook方法)
		List<BookVo> Allbooks=bookservice.getAllBook();
		System.out.println("ListBook Sucess");
		//把後端準備好的資料 (Allbooks)，丟到前端並取名叫 "books"。
		model.addAttribute("books",Allbooks);
		return "BookPage";
	}
	
	
	//跳轉到AddBooks的頁面AddBooks.html
	@GetMapping("/AddBooks")
	public String AddBook(Model model) {
		model.addAttribute("book", new BookVo());
		System.out.println("AddBook Success");
		return "AddBook";
	}
	
	
	//把Service的資料印到前端畫面，並跳回新增畫面
	@PostMapping("/insertBooks")
	public String  AddBooks(@ModelAttribute("book")  BookVo vo) {		
          bookservice.InserBooks(vo);
	return "redirect:/books";
   }
	
	
	//刪除書本
	@PostMapping("/DeleteBooks/{ID}")
	public String DeleteBooks(@PathVariable("ID") Long ID,Model model ) {
		 bookservice.DeleteBooksById(ID);
		 System.out.println("Delete Sucess");
		 return "redirect:/books"; 
	}
	
	
	//跳轉到編輯頁UpdateBooks的頁面UpdateBookPage.html
	//Mapping中的{ID}要與@Pathvarible("ID")要一樣
	//model.addAttribute("book", vo)的book物件要與前端 th:object="${book}對上
	@GetMapping("/ToUpdatePage/{ID}")
	public String UpdatePage(@PathVariable("ID") Long ID, Model model) {
		BookVo vo =bookservice.getBookById(ID);
		 model.addAttribute("book", vo);
		return "UpdateBookPage";
}
	
	
	//編輯書本
	//@PostMapping("/UpdateBook")對上th:action="@{/UpdateBook}
	@PostMapping("/UpdateBook")
	public String UpdateBook(@ModelAttribute("Update") BookVo vo){ 
		 bookservice.updateBooks(vo);
		return "redirect:/books";	
	}

	}
