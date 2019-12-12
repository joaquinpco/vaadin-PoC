package es.uca.iw.wp.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.wp.Entity.Scale;

public interface ScaleRepository extends JpaRepository<Scale, Integer>{
	Scale findById(int _iScaleId);
	
	List<Scale> findAllBy_dTimeNowBetween(LocalDate begin, LocalDate end);
}
