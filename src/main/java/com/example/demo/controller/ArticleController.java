package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Article;
import com.example.demo.service.ArticleService;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService; 
	
	@RequestMapping("/article/getArticles")
	@ResponseBody
	List<Article> getArticles(){
		return articleService.getArticles();
	}
	
	@RequestMapping("/article/add")
	@ResponseBody
	String doAdd(String title, String body){
		int newId = articleService.add(title, body);
		
		return newId + "번 글이 생성되었습니다.";
	}
	
}
