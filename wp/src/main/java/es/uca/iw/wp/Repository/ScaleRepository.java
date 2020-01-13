package es.uca.iw.wp.Repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.uca.iw.wp.Entity.Scale;

public interface ScaleRepository extends JpaRepository<Scale, Integer>{
	
	@Query("select u from Scale u where u.id = :id")
	Scale findByIds(@Param("id") Integer id);
	
	/*@Query("select u from Scale u where u._dTimeNow is between u._dArrive= :dArrive and u._dDeparture= :dDeparture")
	List<Scale> findAllBy_dTimeNow(@Param("dArrive, dDeparture") LocalDate dArrive, LocalDate dDeparture);
	*/
	@Query("select u from Scale u where u._dTimeNow = :now")
	Scale findBy_dTimeNow(@Param("now") LocalDate now);
}