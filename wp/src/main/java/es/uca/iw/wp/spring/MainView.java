package es.uca.iw.wp.spring;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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
        addToNavbar(img);
        addToNavbar(new H1("Bienvenid@ " + SecurityUtils.getSesionUser()));
        
        setContent(new RestaurantView(restaurantService));
		
    }

}
