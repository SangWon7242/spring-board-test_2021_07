package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ArticleDao;
import com.example.demo.dto.Article;

@Service
public class ArticleService {
	@Autowired
	private ArticleDao articleDao;
	 
	public List<Article> getArticles() {		
		return articleDao.getArticles();
	}

	public int add(String title, String body) {
		int id = articleDao.getNewId();
		
		long time = System.currentTimeMillis();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String regDate = dateFormat.format(new Date(time));
		Article newArticle = new Article(id, regDate, title, body);
		
		articleDao.add(newArticle);
			
		return id;
	}

}
