package es.uca.iw.wp.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

import es.uca.iw.wp.Entity.User;
import es.uca.iw.wp.Repository.RestaurantRepository;
import es.uca.iw.wp.Repository.UserRepository;
import es.uca.iw.wp.Security.SecurityUtils;
import es.uca.iw.wp.Services.RestaurantService;
import es.uca.iw.wp.Services.ScaleService;
import es.uca.iw.wp.spring.AdminZone.RestaurantManage;
import es.uca.iw.wp.spring.AdminZone.UserManage;

@Route("")
@Secured({"admin", "user"})
public class MainView extends AppLayout {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1796776387882508405L;

	private RestaurantService _oRestaurantService;
	private ScaleService _oScaleService;
	
	private Button _btnLogOut;
	private Tabs _tabs, _subTabs;
	
	@Autowired
	private UserRepository _oUsrRepository;
	private RestaurantRepository _oRestaurantRepository;
	@Autowired
	private PasswordEncoder _oPasswordEncoder;
	
	public void initializeView(User oUser)
	{	
		Image img = new Image("frontend/img/WPlogo.png", "WPlogo");
        img.setHeight("44px");
        
        _btnLogOut = new Button("Log Out");
         _btnLogOut.getStyle().set("margin-left", "60%");
        addToNavbar(img);
        
        final boolean touchOptimized = true;
        addToNavbar(touchOptimized, new DrawerToggle(), img);
        
        _subTabs = new Tabs(new Tab("Restaurants"), new Tab("Excursions"));
        _subTabs.setOrientation(Tabs.Orientation.VERTICAL);
        Tab book = new Tab("Book");
        book.add(_subTabs);
        
        
        _tabs = new Tabs(new Tab("Home"), new Tab("Scale"), 
        		book, new Tab("Profile"));
        _tabs.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(_tabs);
        
        addToNavbar(new H3("Bienvenid@ " + oUser));
        addToNavbar(_btnLogOut);
        
        
        //En caso del administrador añadimos los menús
        if(oUser.getRole().equals("admin"))
        	_tabs.add(new Tab("User Manage"), new Tab("Ship Manage"), new Tab("Restaurant Manage"));
    
	}
		
	@Autowired
	public MainView(RestaurantService restaurantService, ScaleService scaleService) {
		
		_oRestaurantService = restaurantService;
		_oScaleService = scaleService;
        
		User oUser = SecurityUtils.getSesionUser();
        //Check if admin Logged
        
        initializeView(oUser);
        
        
        
        _btnLogOut.addClickListener(e->{
        	SecurityContextHolder.clearContext();
        	getUI().get().getPage().reload();
        });
        
        _tabs.addSelectedChangeListener(e->{
        	
        	switch(e.getSelectedTab().getElement().getText())
            {
        		
            	case "Scale":
            		setContent(new ScaleView(_oScaleService));
            		break;
            	case "Profile":
            		setContent(new UserView());
            		break;
            	case "User Manage":
            		setContent(new UserManage(_oUsrRepository, _oPasswordEncoder));
            		break;
            	case "Restaurant Manage":
            		setContent(new RestaurantManage(_oRestaurantRepository));
            		break;
            }
        });
        
        //We don´t select at first
        _subTabs.setSelectedTab(null);
        _subTabs.addSelectedChangeListener(e->{
        	switch(e.getSelectedTab().
        			getElement().getText())
        	{
	        	case "Restaurants":
		        	setContent(new RestaurantView(_oRestaurantService));
		        break;
        	}
        });
        
        //Set view for each tab item
        
    }

}
