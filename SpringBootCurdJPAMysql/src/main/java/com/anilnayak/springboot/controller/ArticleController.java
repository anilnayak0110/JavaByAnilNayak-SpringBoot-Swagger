package com.anilnayak.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.anilnayak.springboot.model.Articles;
import com.anilnayak.springboot.service.IArticleService;

@RestController
@RequestMapping("/user")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	
	@GetMapping("/article/{id}")
	public ResponseEntity<Articles> getArticleById(@PathVariable("id") Integer id) {
		Articles article = articleService.getArticleById(id);
		return new ResponseEntity<Articles>(article, HttpStatus.OK);
	}
	
	@GetMapping("/articles")
	public ResponseEntity<List<Articles>> getAllArticles() {
		List<Articles> list = articleService.getAllArticles();
		return new ResponseEntity<List<Articles>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/article")
	public ResponseEntity<Void> addArticle(@RequestBody Articles article, UriComponentsBuilder builder) {
                boolean flag = articleService.addArticle(article);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/article")
	public ResponseEntity<Articles> updateArticle(@RequestBody Articles article) {
		articleService.updateArticle(article);
		return new ResponseEntity<Articles>(article, HttpStatus.OK);
	}
	
	@DeleteMapping("/article/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	

}
