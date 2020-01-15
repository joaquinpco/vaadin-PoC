package es.uca.iw.wp.spring;

import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import es.uca.iw.wp.Entity.User;
import es.uca.iw.wp.Repository.BookRepository;
import es.uca.iw.wp.Security.SecurityUtils;

@Secured({"user", "admin"})
public class UserView extends VerticalLayout{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5073527090749853594L;
	private Button _oBtnMyBooks;
	
	public UserView()
	{
		
		User oUser = SecurityUtils.getSesionUser();
		
		H2 h2Name = new H2("Name: " + oUser.getName());
		
		H2 h2LastName = new H2("Last Name:" + oUser.getLastName());
		
		_oBtnMyBooks = new Button("My Books");
		
		add(h2Name, h2LastName, _oBtnMyBooks);
		
		VerticalLayout oCurrentLayout = this;
		
		_oBtnMyBooks.addClickListener(e->{
			
			oCurrentLayout.removeAll();
			
		});
	}
}
