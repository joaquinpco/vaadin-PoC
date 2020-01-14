package es.uca.iw.wp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.wp.Entity.Book;
import es.uca.iw.wp.Entity.City;

public interface BookRepository extends JpaRepository<Book, String>{

}
