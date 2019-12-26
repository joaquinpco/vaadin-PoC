package es.uca.iw.wp.Services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uca.iw.wp.Entity.Scale;
import es.uca.iw.wp.Repository.ScaleRepository;
@Service
public class ScaleService{
		private ScaleRepository _oScRepository;
		
		@Autowired
		public ScaleService(ScaleRepository oScRepository) {
			_oScRepository = oScRepository;
		}
		/**
		 * Método que solo se podrá usar con el admin
		 * @param entry
		 * @return
		 */
		public Scale findById(int id) {
			return _oScRepository.findByIds(id);
		}
		
		/*public List<Scale> findAllByScaleTimeBetween(LocalDate dArrive, LocalDate dDeparture){
			return _oScRepository.findAllBy_dTimeNow(dArrive, dDeparture);
		}
		*/
		public Scale findBy_dTimeNow(LocalDate now) {
			return _oScRepository.findBy_dTimeNow(now);
		}
	
}
