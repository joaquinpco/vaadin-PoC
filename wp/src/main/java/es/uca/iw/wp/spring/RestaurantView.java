package es.uca.iw.wp.spring;

import com.vaadin.flow.component.accordion.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.uca.iw.wp.Entity.Food;
import es.uca.iw.wp.Entity.Restaurant;
import es.uca.iw.wp.Services.FoodService;
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
	
	private VerticalLayout _oMainContainer;
	
	private SimpleDateFormat _oSf = new SimpleDateFormat("kk:mm");

	//services
	
	private RestaurantService _oRs;
	
	private void initUIView()
	{
		_oAcrdnList = new Accordion();
	}
	
	public RestaurantView(RestaurantService _oRs)
	{
		_oMainContainer = this;
		this._oRs=_oRs;
		
		//Intialize UI/UX
		initUIView();
		
		
		List<Restaurant> oLst = _oRs.listRestaurant();
		
		Iterator<Restaurant> oIter = oLst.iterator();
		

		
		while(oIter.hasNext())
		{
			Restaurant oRestaurant = oIter.next();
			
			_oVrtlMenu = new VerticalLayout();
			_oVrtlHorario = new VerticalLayout();
			_oVrtltables = new VerticalLayout();
			_oVrtlNewRestaurant = new VerticalLayout();
			//Accordions
			
		    _oAcrdnRestaurants = new Accordion();
			
			_oVrtlHorario.add(
					new Span("Hora de apertura: "+ _oSf.format(oRestaurant.getOpen())),
					new Span("Hora de cierre: "+ _oSf.format(oRestaurant.getClose()))
			);
			_oAcrdnRestaurants.add("Horario", _oVrtlHorario);
			
			_oVrtltables.add(
					new Span("Numero de mesas: "+ oRestaurant.getTable())
			);
			
			_oAcrdnRestaurants.add("Mesas", _oVrtltables);
			
			List<Food> oLstFood = oRestaurant.getFoods();
			Iterator<Food> oItrFood = oLstFood.iterator();
			
			while(oItrFood.hasNext()) {
			
				Food oFood = oItrFood.next();
				_oVrtlMenu.add(
							new Span(oFood.getName() +"\t"+ oFood.getPrice()+"€")//sustituir por el nombre del plato de la bbdd
					);
				}
				_oAcrdnRestaurants.add("Menú", _oVrtlMenu);
				//Anchor reserva = new Anchor("http://127.0.0.1:8080/showRestaurants?id_type=1&&id_booking="+oRestaurant.getId()+"", "Reserva");
				Button reserva = new Button("Reserva");
				_oAcrdnRestaurants.add("reservar", reserva);
				
				reserva.addClickListener(e->{
					Long iIdRestaurant = oRestaurant.getId();
					_oMainContainer.removeAll();
					_oMainContainer.add(new BookingView("Restaurants", _oRs, iIdRestaurant));
					
				});
				
				
				
				_oVrtlNewRestaurant.add(_oAcrdnRestaurants);
				_oAcrdnList.add(oRestaurant.getName(), _oVrtlNewRestaurant);
		 	}
		
		add(_oAcrdnList);
	}
	/*
	newRestaurant.add(//nombre del restaurante al añadirlo	
	);*/
}