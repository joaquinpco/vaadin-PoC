package es.uca.iw.wp.spring;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
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
        addToNavbar(new H3("Bienvenid@ " + SecurityUtils.getSesionUser()));
        
        
        addToNavbar(btnLogOut);
        
        setContent(new RestaurantView(restaurantService));
		
    }

}
