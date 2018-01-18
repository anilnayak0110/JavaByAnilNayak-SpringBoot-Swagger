package com.anilnayak.springboot.dao;

import java.util.List;

import com.anilnayak.springboot.model.Articles;

public interface IArticleDao {
	List<Articles> getAllArticles();

	Articles getArticleById(int articleId);

	void addArticle(Articles article);

	void updateArticle(Articles article);

	void deleteArticle(int articleId);

	boolean articleExists(String title, String category);
}
