package diligentia.dao;

import diligentia.model.Article;
import diligentia.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Transactional(readOnly = true)
public interface CompanyRepository extends JpaRepository<Company, Integer> {

	@Query("select m from Company m where m.name like ?1")
	List<Company> getCompanyByName(String name);

}
