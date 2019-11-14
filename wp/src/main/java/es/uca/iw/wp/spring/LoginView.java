package es.uca.iw.wp.spring;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.FormItem;
import com.vaadin.flow.component.html.Image;

public class LoginView extends VerticalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7803619598952746302L;

	public static final CharSequence ROUTE = "";
	
	private FormLayout _oFrmLogin;
	private TextField _oTxtUser;
    private PasswordField _oPwdPassword;
    private Button _oBtnForgotUser;
    private Button _oBtnForgotPwd;
    private Button _oBtnSend;
    private FormItem _oTxtUs;
    
    public LoginView() {
    	
    	_oFrmLogin = new FormLayout();
    	_oBtnForgotUser = new Button("\nUsuario olvidado");
    	_oBtnForgotPwd = new Button("\nContraseña olvidada");
    	_oBtnSend = new Button("Enviar");
    	_oTxtUser = new TextField();
    	_oPwdPassword = new PasswordField();
    	
    	_oTxtUs = _oFrmLogin.addFormItem(_oTxtUser, "Usuario");
    	FormItem _oPwdpwd = _oFrmLogin.addFormItem(_oPwdPassword, "Contraseña");
    	HorizontalLayout actions = new HorizontalLayout(_oBtnSend);
    	VerticalLayout v = new VerticalLayout(_oTxtUs, _oPwdpwd);
    	add(v);
    	Image oImgWhitePearlLogo = new Image("frontend/img/WPlogo.png", "WPlogo");
    	oImgWhitePearlLogo.getStyle().set("width", "75%");
    	oImgWhitePearlLogo.getStyle().set("height", "75%");
    	
    	HorizontalLayout logo = new HorizontalLayout(oImgWhitePearlLogo);
    	
    	_oTxtUs.add(_oBtnForgotUser);
    	_oBtnForgotUser.getStyle().set("marginLeft", "10px");
  
    	_oBtnForgotPwd.getStyle().set("marginLeft", "10px");
    	_oPwdpwd.add(_oBtnForgotPwd);
    	
    	_oBtnSend.getStyle().set("marginLeft", "22.2em");
    	_oBtnSend.getStyle().set("marginTop", "3em");
    	
    	add(logo, v, actions);
    }
}
