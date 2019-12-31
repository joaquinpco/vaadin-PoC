package es.uca.iw.wp;


import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		
		//Test

		Date date = new Date();
		SimpleDateFormat smpDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = smpDateFormat.parse("2019-12-19 09:00:00");
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		Date dateA = new Date(); 
		SimpleDateFormat smpDateFormatCheck = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			dateA = smpDateFormatCheck.parse("2019-12-19 09:00:00");
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		
		Restaurant testRestaurant = new Restaurant("WacDonald", date, dateA, 23);
		
		//Almacenamos el usuario
		oRestaurantRepository.save(testRestaurant);
		
		long iRestaurants = oRestaurantRepository.count();
		
		if(iRestaurants > 0)
	    {
			Restaurant oFoundRestaurant = oRestaurantRepository.findByName("WacDonald");
			Assertions.assertThat(oFoundRestaurant.getName()).isEqualTo("WacDonald");
	    }
		
	}
}
