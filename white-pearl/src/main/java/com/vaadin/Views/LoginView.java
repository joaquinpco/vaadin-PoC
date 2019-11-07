package com.vaadin.Views;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * 
 * @author joaquinpco
 *
 */
@Route("login")
public class LoginView extends VerticalLayout {

	private TextField _oTxtNombreUsuario;
	private PasswordField _oPwdContrasena;
	private FormLayout _oFrmLogin;
	
	public LoginView()
	{		
		//Inicialización de componentes
		_oFrmLogin = new FormLayout();
		_oTxtNombreUsuario = new TextField("Usuario");
		_oPwdContrasena = new PasswordField("Contraseña");
		
		_oFrmLogin.add(_oTxtNombreUsuario, _oPwdContrasena);
		
		//Añadimos los componentes a la vista
		add(_oFrmLogin);
	}
	
}
