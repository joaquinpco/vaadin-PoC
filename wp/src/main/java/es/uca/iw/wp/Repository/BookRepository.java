package es.uca.iw.wp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.uca.iw.wp.Entity.Book;
import es.uca.iw.wp.Entity.User;

public interface BookRepository extends JpaRepository<Book, String>{
	
	@Query("select b from Book b where b._oUser = :oUser")
	List<Book> findByUsers(@Param("oUser") User oUser);
}
