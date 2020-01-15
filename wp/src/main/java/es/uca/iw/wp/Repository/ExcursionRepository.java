package es.uca.iw.wp.Repository;

import es.uca.iw.wp.Entity.Excursion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface ExcursionRepository extends JpaRepository<Excursion, Integer>{
	
	@Query("select u from Excursion u where u.id = :id")
	Excursion findByIds(@Param("id") Integer id);
	
	@Query("select u from Excursion u")
	List<Excursion> listExcursion();
	
	
}
