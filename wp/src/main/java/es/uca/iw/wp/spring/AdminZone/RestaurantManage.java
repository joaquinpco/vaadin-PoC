package es.uca.iw.wp.spring.AdminZone;

import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import es.uca.iw.wp.Entity.Restaurant;
import es.uca.iw.wp.Repository.RestaurantRepository;

public class RestaurantManage extends VerticalLayout{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8613023743986289489L;
	
	private FormLayout _oColumnLayout;
	private TextField _txtName, _txtTable;
	private TimePicker _dtTimeClose, _dtTimeOpen;
	private Date _dtOpen, _dtClose;
	private Button _oBtnNewRestaurant, _oBtnShowRestaurants;
	private Grid<Restaurant> oGrid;
	
	private RestaurantRepository _oRestaurantRepository;

	private DateFormat smpDateFormatCheck;
	
	private void initializeView()
	{
		_oColumnLayout = new FormLayout();
		// Setting the desired responsive steps for the columns in the layout
		_oColumnLayout.setResponsiveSteps(
		           new ResponsiveStep("25em", 1),
		           new ResponsiveStep("32em", 2),
		           new ResponsiveStep("40em", 3));
		
		_txtName = new TextField();
		_txtName.setRequired(true);
		_dtTimeClose = new TimePicker();
		_dtTimeClose.setRequired(true);
		_dtTimeOpen = new TimePicker();
		_dtTimeOpen.setRequired(true);
		
		
	    _txtName.setPlaceholder("Name");
	    
	    TextField _txtTable = new TextField();
	    _txtTable.setPlaceholder("Number of tables"); 
	    _txtTable.setRequired(true);
	    
	    
	    _oColumnLayout.addFormItem(_dtTimeOpen, "Opening time (HH:MM)");
	    _oColumnLayout.addFormItem(_dtTimeClose, "Closing time (HH:MM)");
	 
	    _oBtnNewRestaurant = new Button("Register");
	    _oBtnShowRestaurants = new Button("Show Restaurants");
	    _oColumnLayout.add(_txtName,_txtTable);
	    add(_oColumnLayout, _oBtnNewRestaurant);
	    
	    oGrid = new Grid<>();
	    
	    add(oGrid, _oBtnShowRestaurants);
	    
	}
	    
	    
	    
	    //oGrid.getTreeData().addItems(lstRestaurant.get(0), lstRestaurant);
		 
	
	public RestaurantManage(RestaurantRepository oRestaurantRepository) 
	{	
		_oRestaurantRepository = oRestaurantRepository;
		initializeView();
		
		_oBtnNewRestaurant.addClickListener(e->{
			
			
			if(_txtName.getValue().equals("") || _txtTable.equals("") 
					|| _dtTimeClose.getValue() != null || _dtTimeOpen.getValue() != null)
			{
				Notification.show("Fields are required");
			}
			else
			{
				Restaurant oRestaurant = new Restaurant();
				oRestaurant.setName(_txtName.getValue());
				
				
				String sDate = _dtTimeOpen.getValue().getHour() + ":00:00";
				smpDateFormatCheck = null;
				Date _dtOpen = null;
				try {
					_dtOpen = smpDateFormatCheck.parse(sDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				oRestaurant.setOpen(_dtOpen);
				
				
				sDate = _dtTimeClose.getValue().getHour() + ":00:00";
				Date _dtClose = null;
				try {
					_dtClose = smpDateFormatCheck.parse(sDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				oRestaurant.setClose(_dtClose);
			
				oRestaurant.setTable(Integer.valueOf(_txtTable.getValue()));
				_oRestaurantRepository.save(oRestaurant);
				Notification.show("Restaurant added to our System.");
			}
		});
		
		_oBtnShowRestaurants.addClickListener(e->{
			List<Restaurant> oLstRestaurant = _oRestaurantRepository.listRestaurant();
			
			oGrid.removeAllColumns();
			oGrid.setItems(oLstRestaurant);
			oGrid.addColumn(Restaurant::getName).setHeader("Name");
		});
	}
	
}
