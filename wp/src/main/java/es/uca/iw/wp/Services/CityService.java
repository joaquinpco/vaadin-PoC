package es.uca.iw.wp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uca.iw.wp.Entity.City;
import es.uca.iw.wp.Repository.CityRepository;

@Service
public class CityService {
	public static CityRepository _oCityRepository;
	
	@Autowired
	private CityService(CityRepository oCityRepository) {
		_oCityRepository = oCityRepository;
	}
	
	public City findById(int id) {
		return _oCityRepository.findByIds(id);
	}
}
