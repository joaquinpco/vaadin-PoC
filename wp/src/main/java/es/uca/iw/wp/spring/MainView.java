package es.uca.iw.wp.spring;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import es.uca.iw.wp.Security.SecurityUtils;

@Route("")
@StyleSheet("base.css")
public class MainView extends VerticalLayout {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1796776387882508405L;

	private HorizontalLayout _oHrtlHeader, _oHrtlCenter, _oHrtlFooter;
	private VerticalLayout _oVrtlNavBar, _oVrtlContent;
	private H2 _txtUser;
	
	
	public void initView() 
	{
		   // Instantiate layouts
		   _oHrtlHeader = new HorizontalLayout();
		   _oVrtlNavBar = new VerticalLayout();
		   _oVrtlContent = new VerticalLayout();
		   _oHrtlCenter = new HorizontalLayout();
		   _oHrtlFooter = new HorizontalLayout();
		   _txtUser = new H2();

		   // Configure layouts
		   setSizeFull();
		   setPadding(false);
		   setSpacing(false);
		   
		   _oHrtlHeader.setWidth("100%");
		   _oHrtlHeader.setPadding(true);
		   _oHrtlCenter.setWidth("100%");
		   _oVrtlNavBar.setWidth("200px");
		   _oVrtlContent.setWidth("100%");
		   _oHrtlFooter.setWidth("100%");
		   _oHrtlFooter.setPadding(true);

		   // Compose layout
		   _oHrtlCenter.add(_oVrtlNavBar, _oVrtlContent);
		   _oHrtlCenter.setFlexGrow(1, _oVrtlNavBar);
		   add(_oHrtlHeader, _oHrtlCenter, _oHrtlFooter);
		   expand(_oHrtlCenter);
		   
		   _oHrtlHeader.add(_txtUser);
		   
		   addClassName("mainView");
		   //Adding classnames
		   _oHrtlHeader.addClassName("menu");
		   _oVrtlContent.addClassName("content");
		   _oVrtlNavBar.addClassName("leftsideboard");
		   
		   
	}
		
	
	public MainView() {
		
		/*Image img = new Image("frontend/img/WPlogo.png", "WPlogo");
        img.setHeight("44px");
        addToNavbar(img);
        */
		
		initView();
		
		_txtUser.setText("Bienvenid@ " + SecurityUtils.getSesionUser());
		
    }

}
