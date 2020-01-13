package es.uca.iw.wp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uca.iw.wp.Entity.Excursion;
import es.uca.iw.wp.Repository.ExcursionRepository;
@Service
public class ExcursionService {
	private ExcursionRepository _oExcRepo;
	
	@Autowired
	public ExcursionService(ExcursionRepository oExcRepo) {
		_oExcRepo = oExcRepo;
		
	}
	
	public Excursion findByIds(int id) {return _oExcRepo.findByIds(id);}
	
	public Long count() { return _oExcRepo.count(); }
}
