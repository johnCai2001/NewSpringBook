package com.example.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class BookVo {
	
	private Long ID;
	
	private String Name;
	
	private String Author;
	
	private String Buydate;
	
	private MultipartFile Image;
}
