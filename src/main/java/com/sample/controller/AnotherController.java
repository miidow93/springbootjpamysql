package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.repository.BookRepository;

@Controller
@RequestMapping("/test")
public class AnotherController {
	
	@Autowired
	BookRepository bookRepo;
	
	@GetMapping("/")
	public String index(Model m) {
		long count = bookRepo.count();
		m.addAttribute("count", count);
		System.out.println("----------------- Count -------------------------" + count);
		return "index";
	}

}
