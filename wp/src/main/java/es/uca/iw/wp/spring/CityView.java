package es.uca.iw.wp.spring;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import es.uca.iw.wp.Entity.City;
import es.uca.iw.wp.Services.CityService;

@Route("showCity")
public class CityView extends VerticalLayout{
	private CityService _oCs;
	
	public CityView(CityService oCs) {
		_oCs = oCs;
		
		City c = oCs.findById(0);
		H1 _hCabecera = new H1("Ciudad: " + c.getName());
		H2 _hContenido = new H2("Descripción: "+c.getDescrip());
		add(_hCabecera, _hContenido);	
	}
}
