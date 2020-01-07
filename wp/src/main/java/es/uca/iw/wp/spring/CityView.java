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
	private H1 _hCabecera;
	private H2 _hContenido;
	
	public CityView(CityService oCs) {
		_oCs = oCs;
		
		if(_oCs.count() > 0)
		{
			City c = oCs.findById(0);
			
			_hCabecera = new H1("Ciudad: " + c.getName());
			_hContenido = new H2("Descripción: "+c.getDescrip());
			
			add(_hCabecera, _hContenido);
		}
		else
		{
			_hCabecera = new H1("No hay ciudades disponibles en el sistema");
			add(_hCabecera);
		}
	}
}
