package es.uca.iw.wp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uca.iw.wp.Entity.Excursion;
import es.uca.iw.wp.Entity.Restaurant;
import es.uca.iw.wp.Repository.ExcursionRepository;
@Service
public class ExcursionService {
	private ExcursionRepository _oExcRepo;
	
	@Autowired
	public ExcursionService(ExcursionRepository oExcRepo) {
		_oExcRepo = oExcRepo;
		
	}
	
	public Excursion findByIds(Long _lServiceId) {return _oExcRepo.findByIds(_lServiceId);}
	
	public Long count() { return _oExcRepo.count(); }
	
	public List<Excursion> listExcursion(){ return _oExcRepo.findAll(); }
}
