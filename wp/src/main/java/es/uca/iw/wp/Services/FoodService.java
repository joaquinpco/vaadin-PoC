package es.uca.iw.wp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uca.iw.wp.Entity.Food;
import es.uca.iw.wp.Repository.FoodRepository;
@Service
public class FoodService{
		private FoodRepository _oScRepository;
		
		@Autowired
		private FoodService(FoodRepository oScRepository) {
			_oScRepository = oScRepository;
		}
		
		public List<Food> listFood(){
			return _oScRepository.findAll();
		}
}
