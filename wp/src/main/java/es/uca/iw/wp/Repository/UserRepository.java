package es.uca.iw.wp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.uca.iw.wp.Entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	@Query("select u from User u where u._sName= :name")
	User findByName(@Param("name") String name);
	
	@Query("select u from User u where u._iAccessCode = :iAccessCode")
	User findByAccessCode(@Param("iAccessCode") int iAccessCode);
}
