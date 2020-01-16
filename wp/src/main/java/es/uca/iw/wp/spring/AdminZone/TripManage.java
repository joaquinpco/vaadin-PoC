package es.uca.iw.wp.spring.AdminZone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import es.uca.iw.wp.Entity.Trip;
import es.uca.iw.wp.Repository.TripRepository;

@Secured("admin")
public class TripManage extends VerticalLayout{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8613023743986289489L;
	
	private FormLayout _oColumnLayout;
	private TextField _txtName;
	private Button _oBtnNewTrip, _oBtnShowTrips;
	private Grid<Trip> oGrid;
	
	private TripRepository _oTripRepository;
	
	
	private void initializeView()
	{
		_oColumnLayout = new FormLayout();
		// Setting the desired responsive steps for the columns in the layout
		_oColumnLayout.setResponsiveSteps(
		           new ResponsiveStep("25em", 1),
		           new ResponsiveStep("32em", 2),
		           new ResponsiveStep("40em", 3));
		
		_txtName = new TextField();
	    _txtName.setPlaceholder("Name");

	    _oBtnNewTrip = new Button("Register");
	    _oBtnShowTrips = new Button("Show Trips");
	    
	    oGrid = new Grid<>();
	    
	    
	    
	    //oGrid.getTreeData().addItems(lstTrip.get(0), lstTrip);
		   
	    _oColumnLayout.add(_txtName);
	    add(_oColumnLayout, _oBtnNewTrip, oGrid, _oBtnShowTrips);
	}
	
	public TripManage(TripRepository oTripRepository) 
	{
		initializeView();
		
		_oTripRepository = oTripRepository;
		
		_oBtnNewTrip.addClickListener(e->{
			
			if(_txtName.getValue().equals(""))
			{
				Notification.show("Fields are required");
			}
			else
			{
				Trip oTrip = new Trip();
				oTrip.setName(_txtName.getValue());
				_oTripRepository.save(oTrip);
				Notification.show("Trip added to our System.");
			}
		});
		
		_oBtnShowTrips.addClickListener(e->{
			List<Trip> oLstTrip = _oTripRepository.findAll();
			
			oGrid.removeAllColumns();
			
			oGrid.setItems(oLstTrip);
			oGrid.addColumn(Trip::getName).setHeader("Name");
			//oGrid.getTreeData().addItems(oLstTrip.get(0), oLstTrip);
		});
	}
	
}
