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
import es.uca.iw.wp.Services.ScaleService;

@Route("")
public class MainView extends AppLayout {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1796776387882508405L;

	private RestaurantService _oRestaurantService;
	
	private ScaleService _oScaleService;
		
	@Autowired
	public MainView(RestaurantService restaurantService, ScaleService scaleService) {
		
		_oRestaurantService = restaurantService;
		_oScaleService = scaleService;
		
		Image img = new Image("frontend/img/WPlogo.png", "WPlogo");
        img.setHeight("44px");
        
        Button btnLogOut = new Button("log Out");
        btnLogOut.getStyle().set("margin-left", "60%");
        addToNavbar(img);
        
        final boolean touchOptimized = true;
        addToNavbar(touchOptimized, new DrawerToggle(), img);
        
        Tabs subTabs = new Tabs(new Tab("Restaurants"), new Tab("Excursions"));
        subTabs.setOrientation(Tabs.Orientation.VERTICAL);
        Tab book = new Tab("Book");
        book.add(subTabs);
        
        
        Tabs tabs = new Tabs(new Tab("Home"), new Tab("Scale"), 
        		book, new Tab("Profile"));
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(tabs);
        
        
        addToNavbar(new H3("Bienvenid@ " + SecurityUtils.getSesionUser()));
        addToNavbar(btnLogOut);
        
        btnLogOut.addClickListener(e->{
        	SecurityContextHolder.clearContext();
        	getUI().get().getPage().reload();
        });
        
        tabs.addSelectedChangeListener(e->{
        	
        	switch(e.getSelectedTab().getElement().getText())
            {
            	case "Scale":
            		setContent(new ScaleView(_oScaleService));
            		break;
            	case "Profile":
            		setContent(new UserView());
            		break;
            }
        });
        
        subTabs.addSelectedChangeListener(e->{
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
