package es.uca.iw.wp.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import es.uca.iw.wp.Entity.User;
import es.uca.iw.wp.Security.SecurityUtils;

public class UserView extends VerticalLayout{
	
	private Button _oBtnMisGastos;
	
	public UserView()
	{
		User oUser = SecurityUtils.getSesionUser();
		
		H2 h2Name = new H2("Name: " + oUser.getName());
		
		H2 h2LastName = new H2("Last Name:" + oUser.getLastName());
		
		_oBtnMisGastos = new Button("My expenses");
		
		add(h2Name, h2LastName, _oBtnMisGastos);
	}
}
