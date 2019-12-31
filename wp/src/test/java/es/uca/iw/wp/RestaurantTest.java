package es.uca.iw.wp;


import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.uca.iw.wp.Entity.Restaurant;
import es.uca.iw.wp.Repository.RestaurantRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.ANY)
public class RestaurantTest 
{	
	
	@Autowired
	private RestaurantRepository oRestaurantRepository;
	
	@Test
	public void testSaveAndFindResturant()
	{
		String sNombre = "";
		//Test
		@SuppressWarnings("deprecation")
		Date dateO = new Date("2019-12-19 09:00:00");
		@SuppressWarnings("deprecation")
		Date dateC = new Date("2019-12-19 09:00:00");
		
		Restaurant testRestaurant = new Restaurant("WacDonald", dateO,dateC, 23);
		
		//Almacenamos el usuario
		oRestaurantRepository.save(testRestaurant);
		
		
		Restaurant oFoundRestaurant = oRestaurantRepository.findByNames("WacDonald");
		sNombre = oFoundRestaurant.getName();
		
		Assertions.assertThat(sNombre).isEqualTo("WacDonald");
		
	}
}
