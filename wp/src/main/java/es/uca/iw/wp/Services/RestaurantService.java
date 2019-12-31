package es.uca.iw.wp.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uca.iw.wp.Entity.Restaurant;
import es.uca.iw.wp.Repository.RestaurantRepository;
@Service
public class RestaurantService{
		private static RestaurantRepository _oScRepository;
		private static RestaurantService _oRstService;
		
		@Autowired
		private RestaurantService(RestaurantRepository oScRepository) {
			_oScRepository = oScRepository;
		}
		
		
		public Restaurant findById(int id) {
			return _oScRepository.findByIds(id);
		}
		public Restaurant findByName(String name) {
			return _oScRepository.findByNames(name);
		}
		public List<Restaurant> listRestaurant(){
			return _oScRepository.findAll();
		}
}
