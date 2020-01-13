package es.uca.iw.wp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.uca.iw.wp.Entity.Ship;

public interface ShipRepository extends JpaRepository<Ship, String>{
	
	@Query("select u from Ship u where u._sName= :name")
	Ship findByName(@Param("name") String name);
}
