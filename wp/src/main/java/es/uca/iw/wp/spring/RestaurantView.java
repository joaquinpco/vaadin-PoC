package es.uca.iw.wp.spring;

import com.vaadin.flow.component.accordion.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.uca.iw.wp.Entity.Restaurant;
import es.uca.iw.wp.Services.RestaurantService;

@Route("showRestaurants")
public class RestaurantView extends VerticalLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * UI/UX atributes
	 */
	private Accordion _oAcrdnRestaurants;
	private Accordion _oAcrdnList;

	private VerticalLayout _oVrtlHorario;
	private VerticalLayout _oVrtltables;
	private VerticalLayout _oVrtlMenu;
	private VerticalLayout _oVrtlNewRestaurant;

	//services
	
	private RestaurantService _oRs;
	
	private void initUIView()
	{
		//Vertical Layout
		_oVrtlNewRestaurant = new VerticalLayout();
		_oVrtlMenu = new VerticalLayout();
		_oVrtlHorario = new VerticalLayout();
		_oVrtltables = new VerticalLayout();
		//Accordions
		_oAcrdnList = new Accordion();
	    _oAcrdnRestaurants = new Accordion();
	    
	  /*Se lo carga todo
	  		auxiliarVL.removeAll();*/
	}
	
	public RestaurantView(RestaurantService _oRs )
	{
		this._oRs=_oRs;
		
		//Intialize UI/UX
		initUIView();
		
		
		List<Restaurant> oLst = _oRs.listRestaurant();
		
		Iterator<Restaurant> oIter = oLst.iterator();
		
		while(oIter.hasNext())
		{
			Restaurant oRestaurant = oIter.next();
			
			_oVrtlHorario.add(
					new TextField("Hora de apertura: "+ oRestaurant.getOpen()),
					new TextField("Hora de cierre: "+ oRestaurant.getClose())
			);
			_oAcrdnRestaurants.add("Horario", _oVrtlHorario);
			
			_oVrtltables.add(
					new TextField("Numero de mesas: "+ oRestaurant.getTable())
			);
			_oAcrdnRestaurants.add("Mesas", _oVrtlHorario);
			
			//while(//mas elementos de la bbdd para comidas enlazadas a restaurant) {
			_oVrtlMenu.add(
						new TextField("Nombre Plato, Precio Plato €")//sustituir por el nombre del plato de la bbdd
				);
			//}
			_oAcrdnRestaurants.add("Menú", _oVrtlMenu);
			
			_oVrtlNewRestaurant.add(_oAcrdnRestaurants);
			_oAcrdnList.add(oRestaurant.getName(), _oVrtlNewRestaurant);
		}
		
		
	}
	/*
	newRestaurant.add(//nombre del restaurante al añadirlo	
	);*/
}
