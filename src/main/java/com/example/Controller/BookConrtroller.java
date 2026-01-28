package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.BookService;

@Controller
public class BookConrtroller {

	@Autowired
	private BookService bookservice;

	@GetMapping("/")
	public String Login() {
		System.out.println("Login Success");
		return "Login";
	}
}
