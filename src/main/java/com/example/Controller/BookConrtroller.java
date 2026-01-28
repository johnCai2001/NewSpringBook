package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		//BookVo沒辦法直接用BookEntity，所以要在Service用迴圈去轉換
		List<BookVo> Allbooks=bookservice.getAllBook();
		System.out.println("ListBook Sucess");
		model.addAttribute("books",Allbooks);
		return "BookPage";
	}
}
