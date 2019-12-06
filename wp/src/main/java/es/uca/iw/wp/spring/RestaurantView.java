package es.uca.iw.wp.spring;

import com.vaadin.flow.component.accordion.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class RestaurantView extends VerticalLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * UI/UX atributes
	 */
	private Accordion _oAcrdnRestaurants;
	private Accordion _oAcrdnHorario;
	private Accordion _oAcrdntables;
	private Accordion _oAcrdnMenu;
	private VerticalLayout _oVrtlNewRestaurant;
	private VerticalLayout _oVrtlAuxiliar;
	
	private void initUIView()
	{
		//Vertical Layout
		_oVrtlNewRestaurant = new VerticalLayout();
		_oVrtlAuxiliar = new VerticalLayout();
		
		//Accordions
		_oAcrdnHorario = new Accordion();
		_oAcrdntables = new Accordion();
	    _oAcrdnMenu = new Accordion();
	    _oAcrdnRestaurants = new Accordion();
	  /*Se lo carga todo
	  		auxiliarVL.removeAll();*/
	}
	//auxiliarVL.removeAll();
	public RestaurantView()
	{
		//Intialize UI/UX
		initUIView();
		
		
	}
	/*
	newRestaurant.add(//nombre del restaurante al añadirlo
		
	);*/
}
