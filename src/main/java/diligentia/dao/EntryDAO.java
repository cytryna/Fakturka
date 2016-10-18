package diligentia.dao;

import java.util.List;

import diligentia.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EntryDAO extends JpaRepository<Entry, Integer> {

	@Query("select m from Entry m where m.name like ?1")
	List<Entry> getEntryByName(String name);

}
