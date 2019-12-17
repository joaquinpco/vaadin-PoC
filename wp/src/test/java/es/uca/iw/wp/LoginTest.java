package es.uca.iw.wp;


import static org.junit.Assert.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import es.uca.iw.wp.Entity.User;
import es.uca.iw.wp.Repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.ANY)
public class LoginTest 
{	
	
	@Autowired
	private UserRepository oUserRepository;
	@Autowired
	private PasswordEncoder oPasswordEncoder;
	
	@Test
	public void testSaveAndFindUser()
	{
		String sNombre = "";
		//Test
		User testUser = new User("Joaquin", "Perez Calderon Ortiz", 
				oPasswordEncoder.encode("1234"), 1112);
		
		//Almacenamos el usuario
		oUserRepository.save(testUser);
		
		
		User oFoundUser = oUserRepository.findByName("Joaquin");
		sNombre = oFoundUser.getName();
		
		Assertions.assertThat(sNombre).isEqualTo("Joaquin");
		
	}
}
