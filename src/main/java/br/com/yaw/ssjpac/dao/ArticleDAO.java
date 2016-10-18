package br.com.yaw.ssjpac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import diligentia.entity.Entry;
@Deprecated
public interface ArticleDAO extends JpaRepository<Entry, Integer> {

	@Query("select m from Entry m where m.name like ?1")
	List<Entry> getArticleByName(String name);

}
