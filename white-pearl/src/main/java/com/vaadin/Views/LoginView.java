package com.vaadin.Views;


import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import java.io.File;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.FormItem;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
@Route("/login")
	public class LoginView extends VerticalLayout {
		FormLayout login = new FormLayout();
		private TextField _oTxtUser = new TextField();
	    private PasswordField _oPwdPassword = new PasswordField();
	    private Button btnForgotUser = new Button("\nUsuario olvidado");
	    private Button btnForgotPwd = new Button("\nContraseña olvidada");
	    private Button btnSend = new Button("Enviar");
	    public LoginView() {
	    	login.addFormItem(_oTxtUser, "Usuario");
	    	FormItem _oTxtUs = login.addFormItem(_oTxtUser, "Usuario");
	    	_oTxtUs.add(btnForgotUser);
	    	btnForgotUser.getStyle().set("marginLeft", "10px");
	    	
	    	FormItem _oPwdpwd = login.addFormItem(_oPwdPassword, "Contraseña");
	    	btnForgotPwd.getStyle().set("marginLeft", "10px");
	    	_oPwdpwd.add(btnForgotPwd);
	    	
	    	HorizontalLayout actions = new HorizontalLayout(btnSend);
	    	
	    	btnSend.getStyle().set("marginLeft", "22.2em");
	    	btnSend.getStyle().set("marginTop", "3em");
	    	
	    	Image image = new Image("frontend/img/WPlogo.png", "WPlogo");
	    	image.getStyle().set("width", "50%");
	    	image.getStyle().set("height", "50%");
	    	HorizontalLayout logo = new HorizontalLayout(image);
	    	VerticalLayout v = new VerticalLayout(_oTxtUs, _oPwdpwd);
	    	add(logo, v, actions);
	    }
}
