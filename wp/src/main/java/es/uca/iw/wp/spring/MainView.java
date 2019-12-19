package es.uca.iw.wp.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

import es.uca.iw.wp.Security.SecurityUtils;
import es.uca.iw.wp.Services.RestaurantService;

@Route("")
public class MainView extends AppLayout {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1796776387882508405L;

	private RestaurantService restaurantService;
		
	@Autowired
	public MainView(RestaurantService restaurantService) {
		this.restaurantService=restaurantService;
		Image img = new Image("frontend/img/WPlogo.png", "WPlogo");
        img.setHeight("44px");
        Button btnLogOut = new Button("log Out");
        
        addToNavbar(img);
        
        final boolean touchOptimized = true;
        addToNavbar(touchOptimized, new DrawerToggle(), img);
        Tabs tabs = new Tabs(new Tab("Home"), new Tab("Scale"), 
        		new Tab("Book"), new Tab("Profile"));
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        
        addToDrawer(tabs);
        
        
        addToNavbar(new H3("Bienvenid@ " + SecurityUtils.getSesionUser()));
        
        
        addToNavbar(btnLogOut);
        
        btnLogOut.addClickListener(e->{
        	SecurityContextHolder.clearContext();
        	getUI().get().getPage().reload();
        });
        
        
        setContent(new RestaurantView(restaurantService));
    }

}
