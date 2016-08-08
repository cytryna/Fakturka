package br.com.yaw.ssjpac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import diligentia.model.Article;

public interface ArticleDAO extends JpaRepository<Article, Integer> {

	@Query("select m from Article m where m.name like ?1")
	List<Article> getArticleByName(String name);

}
