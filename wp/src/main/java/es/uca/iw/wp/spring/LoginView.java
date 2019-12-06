package es.uca.iw.wp.spring;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import es.uca.iw.wp.Security.CustomRequestCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.FormItem;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;

@Tag("sa-login-View")
@Route("login")
public class LoginView extends VerticalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7803619598952746302L;
	
	
	public static final CharSequence ROUTE = "login";

    private AuthenticationManager _oAuthenticationProvider;
	
	private FormLayout _oFrmLogin;
	private TextField _oTxtUser;
    private PasswordField _oPwdPassword;
    private Button _oBtnForgotUser;
    private Button _oBtnForgotPwd;
    private Button _oBtnSend;
    private FormItem _oTxtUs;
    
    public void initView()
    {
    	_oFrmLogin = new FormLayout();
    	_oBtnForgotUser = new Button("\nForgotten User?");
    	_oBtnForgotPwd = new Button("\nForgotten Password?");
    	_oBtnSend = new Button("Enviar");
    	_oTxtUser = new TextField();
    	_oPwdPassword = new PasswordField();
    	
    	_oTxtUs = _oFrmLogin.addFormItem(_oTxtUser, "User");
    	FormItem _oPwdpwd = _oFrmLogin.addFormItem(_oPwdPassword, "Password");
    	HorizontalLayout actions = new HorizontalLayout(_oBtnSend);
    	VerticalLayout v = new VerticalLayout(_oTxtUs, _oPwdpwd);
    	add(v);
    	Image oImgWhitePearlLogo = new Image("frontend/img/WPlogo.png", "WPlogo");
    	oImgWhitePearlLogo.getStyle().set("width", "10%");
    	oImgWhitePearlLogo.getStyle().set("height", "10%");
    	
    	HorizontalLayout logo = new HorizontalLayout(oImgWhitePearlLogo);
    	
    	_oTxtUs.add(_oBtnForgotUser);
    	_oBtnForgotUser.getStyle().set("marginLeft", "10px");
  
    	_oBtnForgotPwd.getStyle().set("marginLeft", "10px");
    	_oPwdpwd.add(_oBtnForgotPwd);
    	
    	_oBtnSend.getStyle().set("marginLeft", "22.2em");
    	_oBtnSend.getStyle().set("marginTop", "3em");
    	
    	add(logo, v, actions);
    }
    
    /**
     * 
     * @param oAuthenticationProvider Proveedor de autentication
     */
    @Autowired
    public LoginView(AuthenticationManager oAuthenticationProvider) {
    	
    	//UI Components initialization
    	initView();
    	
    	_oAuthenticationProvider = oAuthenticationProvider;
    	
    	_oBtnSend.addClickListener(e -> 
    	{	
    		//Iniciar Sesíon
    		String sName = _oTxtUser.getValue();
    		String sPassWord = _oPwdPassword.getValue();
    		//Comprobamos el login de usuario
    		Authentication auth = new UsernamePasswordAuthenticationToken(sName,
                    sPassWord);
    		try 
    		{
    			
             final Authentication authenticated = _oAuthenticationProvider.authenticate(auth);
             SecurityContextHolder.getContext().setAuthentication(authenticated);
             
             
             getUI().ifPresent(ui -> ui.navigate(MainView.class));
             
             //getUI().get().getPage().reload();
             
            } 
    		catch (BadCredentialsException e1) 
    		{
              Notification.show("Invalid credentials:" + e1.getMessage());
            }
    		
    	});
    }
}
