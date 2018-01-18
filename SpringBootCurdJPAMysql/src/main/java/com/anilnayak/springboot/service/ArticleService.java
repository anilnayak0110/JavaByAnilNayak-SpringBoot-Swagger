package com.anilnayak.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anilnayak.springboot.dao.IArticleDao;
import com.anilnayak.springboot.model.Articles;

@Service
public class ArticleService implements IArticleService {
	@Autowired
	private IArticleDao dao;

	@Override
	public List<Articles> getAllArticles() {
		return dao.getAllArticles();
	}

	@Override
	public Articles getArticleById(int articleId) {
		return dao.getArticleById(articleId);
	}

	@Override
	public boolean addArticle(Articles article) {
		
		if (dao.articleExists(article.getTitle(), article.getCategory())) {
			return false;
		} else {
			dao.addArticle(article);
			return true;
		}
	}

	@Override
	public void updateArticle(Articles article) {
		dao.updateArticle(article);
	}

	@Override
	public void deleteArticle(int articleId) {
		dao.deleteArticle(articleId);
	}

}
