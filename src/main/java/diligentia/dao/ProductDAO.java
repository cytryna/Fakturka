package diligentia.dao;

import java.util.List;

import diligentia.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductDAO extends JpaRepository<Product, Integer> {

	@Query("select m from Product m where m.name like ?1")
	List<Product> getProductByName(String name);

}
