package es.uca.iw.wp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import es.uca.iw.wp.Entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, String>{
	
	@Query("select u from Restaurant u")
	List<Restaurant> listRestaurant();
	
	@Query("select u from Restaurant u where u.id = :id ")
	Restaurant findByIds(@Param("id") long id);
	
	@Query("select u from Restaurant u where u._sName = :name")
	Restaurant findByName(@Param("name") String sName);
}
