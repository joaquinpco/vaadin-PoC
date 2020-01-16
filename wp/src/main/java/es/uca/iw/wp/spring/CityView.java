package es.uca.iw.wp.spring;

import java.util.Iterator;
import java.util.List;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import es.uca.iw.wp.Entity.City;
import es.uca.iw.wp.Entity.Excursion;
import es.uca.iw.wp.Services.CityService;
@Route("showCity")
public class CityView extends VerticalLayout{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3965666028889049549L;
	
	private CityService _oCs;
	private H1 _hCabecera;
	private H2 _hContenido;
	private VerticalLayout CityMenu = new VerticalLayout();
	
	public CityView(CityService oCs, String nomCiudad) {
		_oCs = oCs;
		
		if(_oCs.count() > 0)
		{
			City c = oCs.findById(0);
			
			_hCabecera = new H1("Ciudad: " + c.getName());
			_hContenido = new H2("Descripción: "+c.getDescrip());
			List<Excursion> oLstExcursion = c.getExcursions();
			Iterator<Excursion> oItrExc = oLstExcursion.iterator();
			while(oItrExc.hasNext()) {
				Excursion oExc = oItrExc.next();
				CityMenu.add(
						new Span(oExc.getExcursionName() + "\n" + oExc.getPrice() + " €"));
				
			}
			
			add(_hCabecera, _hContenido, CityMenu);
		}
		else
		{
			_hCabecera = new H1("No hay ciudades disponibles en el sistema");
			add(_hCabecera);
		}
		
	}
}
