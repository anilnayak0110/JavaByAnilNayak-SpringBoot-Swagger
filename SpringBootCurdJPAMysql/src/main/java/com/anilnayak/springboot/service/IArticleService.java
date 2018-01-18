package com.anilnayak.springboot.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.anilnayak.springboot.model.Articles;

public interface IArticleService {
	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	List<Articles> getAllArticles();

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	Articles getArticleById(int articleId);

	@Secured({ "ROLE_ADMIN" })
	boolean addArticle(Articles article);

	@Secured({ "ROLE_ADMIN" })
	void updateArticle(Articles article);

	@Secured({ "ROLE_ADMIN" })
	void deleteArticle(int articleId);
}
