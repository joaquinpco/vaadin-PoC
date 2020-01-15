package es.uca.iw.wp.spring;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;

import es.uca.iw.wp.Entity.Book;
import es.uca.iw.wp.Entity.Restaurant;
import es.uca.iw.wp.Entity.User;
import es.uca.iw.wp.Repository.BookRepository;
import es.uca.iw.wp.Security.SecurityUtils;
import es.uca.iw.wp.Services.RestaurantService;

@Secured({"admin", "user"})
public class BookingView extends VerticalLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7000936254875598952L;
	
	private String _sBookType;
	private Object _oServiceType;
	private Long _lServiceId;
	
	private FormLayout _oLytWithFormItems = new FormLayout();
	private ComboBox<String> _oLblBookingName = new ComboBox<>();
	private TextField _oTxtNClient = new TextField();
	private DatePicker _oDatePicker = new DatePicker();
	private TimePicker _oTimePicker = new TimePicker();
	private Button _oBtnBook = new Button("Book");
	
	
	private Restaurant _oCurrentRestaurant;
	
	
	private BookRepository _oBookRep;
	
	
	private void initializeView(String sBookType, Object oServicio, Long lServiceId)
	{
		
		if(oServicio instanceof RestaurantService)
		{
				//Booking Restaurants
				RestaurantService oRestaurantService = (RestaurantService) oServicio;
				
				if(oRestaurantService.count() > 0)
				{
					_oCurrentRestaurant = oRestaurantService.findById(_lServiceId);
					
					_oLblBookingName.setItems(_oCurrentRestaurant.getName());
					
					_oLblBookingName.setValue(_oCurrentRestaurant.getName());
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
	public BookingView(String sBookType,Object oServicio, Long lServiceId, BookRepository oBookRep)
	{
		_sBookType = sBookType;
		_oServiceType = oServicio;
		_lServiceId = lServiceId;
		_oBookRep = oBookRep;
		
		initializeView(_sBookType, _oServiceType, lServiceId);
		
		_oBtnBook.addClickListener(e ->{
			
			if(_oTxtNClient.getValue().equals("") || _oTimePicker.getValue() == null)
			{
				Notification.show("Fill the gaps");
			}
			else
			{
				//Obtenemos los resultados para almacenar
				LocalDate oLclDate = _oDatePicker.getValue();
				LocalTime oLclTime = _oTimePicker.getValue();
				
				//Get Specific data 
				int iYear = oLclDate.getYear();
				int iMonth = oLclDate.getMonthValue();
				int iDay = oLclDate.getDayOfMonth();
				
				int iHour = oLclTime.getHour();
				
				SimpleDateFormat smpDateFormatCheck = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				String sDate = iYear + "-" + iMonth + "-" + iDay + " " + iHour + ":00:00";
				try 
				{
					Date dReserva = smpDateFormatCheck.parse(sDate);
					Integer iCustomers = Integer.valueOf(_oTxtNClient.getValue());
					int iMesas = new Random().nextInt(_oCurrentRestaurant.getTable());
					Book oBook = new Book();
					//Type Restaurant
					oBook.setTipo(1);
					oBook.setFechaReserva(dReserva);
					oBook.setAforoPosicionUser(iMesas);
					
					User oCurrentUser  = SecurityUtils.getSesionUser();
					oBook.setBookUser(oCurrentUser);
					
					
					oBookRep.save(oBook);
					
					Notification.show("Your restaurant was successfully booked");
					oCurrentUser.addUser(oBook);
				}
				catch(Exception ex) {}
			
			}
			
		});
	}
	
}
