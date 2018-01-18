package com.anilnayak.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import com.anilnayak.springboot.model.Articles;

@Transactional
@Repository
@EntityScan("com.anilnayak.springboot.model")
public class ArticleDao implements IArticleDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Articles> getAllArticles() {

		String hql = "FROM Articles as atcl ORDER BY atcl.articleId";
		return entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Articles getArticleById(int articleId) {
		return entityManager.find(Articles.class, articleId);
	}

	@Override
	public void addArticle(Articles article) {
		entityManager.persist(article);
	}

	@Override
	public void updateArticle(Articles article) {
		Articles artcl = getArticleById(article.getArticleId());
		artcl.setTitle(article.getTitle());
		artcl.setCategory(article.getCategory());
		entityManager.flush();
	}

	@Override
	public void deleteArticle(int articleId) {
		entityManager.remove(getArticleById(articleId));
	}

	@Override
	public boolean articleExists(String title, String category) {
		String hql = "FROM Articles as atcl WHERE atcl.title = ? and atcl.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title).setParameter(2, category).getResultList()
				.size();
		return count > 0 ? true : false;
	}

}
