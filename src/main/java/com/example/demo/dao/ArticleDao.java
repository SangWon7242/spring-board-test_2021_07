package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.Article;

@Component
public class ArticleDao {
	private int lastId;
	private List<Article> articles;

	ArticleDao() {
		lastId = 0;
		articles = new ArrayList<>();
	}

	public List<Article> getArticles() {
		return articles;
	}

	public int getNewId() {
		return lastId + 1;
	}

	public void add(Article newArticle) {
		lastId = newArticle.getId();
		articles.add(newArticle);
		
	}
	
}
