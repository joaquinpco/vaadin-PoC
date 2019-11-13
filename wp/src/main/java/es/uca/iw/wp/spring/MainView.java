package es.uca.iw.wp.spring;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends AppLayout {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1796776387882508405L;

	public MainView() {
		Image img = new Image("frontend/img/WPlogo.png", "WPlogo");
        img.setHeight("44px");
        addToNavbar(img);
        setContent(new LoginView());
    }

}
