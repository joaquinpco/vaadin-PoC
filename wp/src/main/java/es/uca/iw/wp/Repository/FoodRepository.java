package es.uca.iw.wp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import es.uca.iw.wp.Entity.Food;

public interface FoodRepository extends JpaRepository<Food, Integer>{
	
	@Query("select u from Food u")
	List<Food> listFood();
}
