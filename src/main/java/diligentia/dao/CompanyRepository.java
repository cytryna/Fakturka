package diligentia.dao;

import diligentia.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//@Transactional(readOnly = true)
public interface CompanyRepository extends JpaRepository<Company, Integer> {

	@Query("select m from Company m where m.name like ?1")
	List<Company> getCompanyByName(String name);

}
