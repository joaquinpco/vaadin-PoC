package es.uca.iw.wp.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uca.iw.wp.Entity.Restaurant;
import es.uca.iw.wp.Repository.RestaurantRepository;
@Service
public class RestaurantService{
	
		private static RestaurantRepository _oScRepository;
		
		@Autowired
		private RestaurantService(RestaurantRepository oScRepository) {
			_oScRepository = oScRepository;
		}
		
		
		public Restaurant findById(Long id) { return _oScRepository.findByIds(id); }
		
		public Restaurant findByName(String name) { return _oScRepository.findByName(name); }
		
		public List<Restaurant> listRestaurant(){ return _oScRepository.findAll(); }
		
		public Long count() { return _oScRepository.count(); }
}
