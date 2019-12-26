package es.uca.iw.wp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.uca.iw.wp.Entity.City;

public interface CityRepository extends JpaRepository<City, Integer>{
	@Query("select u from City u where u._iId =:id")
	City findByIds(@Param("id") Integer id);

}
