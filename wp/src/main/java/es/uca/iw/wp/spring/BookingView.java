package es.uca.iw.wp.spring;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;

import es.uca.iw.wp.Entity.Restaurant;
import es.uca.iw.wp.Services.RestaurantService;

public class BookingView extends VerticalLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7000936254875598952L;
	
	private String _sBookType;
	private Object _oServiceType;
	
	private FormLayout _oLytWithFormItems = new FormLayout();
	private ComboBox<String> _oLblBookingName = new ComboBox<>();
	private TextField _oTxtNClient = new TextField();
	private DatePicker _oDatePicker = new DatePicker();
	private TimePicker _oTimePicker = new TimePicker();
	private Button _oBtnBook = new Button("Book");
	
	
	private List<Restaurant> _oLstRestaurantes;
	
	
	
	private void initializeView(String sBookType, Object oServicio)
	{
		
		
		if(oServicio instanceof RestaurantService)
		{
			//Booking Restaurants
				RestaurantService oRestaurantService = (RestaurantService) oServicio;
				
				if(oRestaurantService.count() > 0)
				{
					_oLstRestaurantes = oRestaurantService.listRestaurant();
					
					for(Restaurant rst : _oLstRestaurantes)
						_oLblBookingName.setItems(rst.getName());
					
					_oLblBookingName.setValue(_oLstRestaurantes.get(0).getName());
				}
				else
				{
					_oLblBookingName.setEnabled(false);
					_oBtnBook.setEnabled(false);
					_oTxtNClient.setEnabled(false);
					_oDatePicker.setEnabled(false);
					_oTimePicker.setEnabled(false);
					
				}
				
				_oLblBookingName.setLabel("Booking " + sBookType);
				
				_oLytWithFormItems.add(_oLblBookingName);
				
				_oDatePicker.setValue(LocalDate.now());
				
				_oLytWithFormItems.addFormItem(_oTxtNClient, "Nº Clients");
				_oLytWithFormItems.addFormItem(_oDatePicker, "DD/MM/YYYY");
				_oLytWithFormItems.addFormItem(_oTimePicker, "HH:MM");
			
				add(_oLytWithFormItems, _oBtnBook);
		}
		else
		{
			//Booking Excursions
		}
		
	}
	
	/**
	 * 
	 * @param sBookType Cadena representante del servicio
	 * @param oServicio Service ya bien sea el de Excursiones o Restaurantes
	 */
	public BookingView(String sBookType,Object oServicio)
	{
		_sBookType = sBookType;
		_oServiceType = oServicio;
		
		initializeView(_sBookType, _oServiceType);
		
		_oBtnBook.addClickListener(e ->{
			
			//Obtenemos los resultados para almacenar
			LocalDate oLclDate = _oDatePicker.getValue();
			LocalTime oLclTime = _oTimePicker.getValue();
			
		});
	}
	
}
