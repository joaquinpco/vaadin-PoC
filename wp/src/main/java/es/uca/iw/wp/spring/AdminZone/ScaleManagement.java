package es.uca.iw.wp.spring.AdminZone;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.component.datepicker.DatePicker;

import es.uca.iw.wp.Entity.Scale;
import es.uca.iw.wp.Repository.ScaleRepository;

public class ScaleManagement extends VerticalLayout{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3307487592402693587L;
	
	private FormLayout _oScaleLayout;
	private TextField _txtPort;
	private DatePicker _dtDateArrive, _dtDateDeparture;
	private TimePicker _dtTimeArrive, _dtTimeDeparture;

	private Date _dtArrive, _dtDeparture;
	private Button _oBtnNewScale, _oBtnShowScales;
	private Grid<Scale> oGridScale;
	
	private ScaleRepository _oScaleRepo;

	private DateFormat smpDateFormatCheck;
	
	private void initializeView()
	{
		_oScaleLayout = new FormLayout();
		// Setting the desired responsive steps for the columns in the layout
		_oScaleLayout.setResponsiveSteps(
		           new ResponsiveStep("25em", 1),
		           new ResponsiveStep("32em", 2),
		           new ResponsiveStep("40em", 3));
		
		_txtPort = new TextField();
		_txtPort.setRequired(true);
		_txtPort.setPlaceholder("Port's name");
		
		_dtDateDeparture = new DatePicker();
		_dtDateDeparture.setRequired(true);
		_dtDateDeparture.setPlaceholder("Departure date");
		_dtTimeDeparture = new TimePicker();
		_dtTimeDeparture.setRequired(true);
		_dtTimeDeparture.setPlaceholder("Departure time");
		
		_dtDateArrive = new DatePicker();
		_dtDateArrive.setRequired(true);
		_dtDateArrive.setPlaceholder("Arrive date");
		_dtTimeArrive = new TimePicker();
		_dtTimeArrive.setRequired(true);
		_dtTimeArrive.setPlaceholder("Arrive time");
		
	    _oScaleLayout.addFormItem(_dtDateArrive, "Arrive at");
	    _oScaleLayout.addFormItem(_dtTimeArrive, "Arrive time");
	    _oScaleLayout.addFormItem(_dtDateDeparture, "Departure at");
	    _oScaleLayout.addFormItem(_dtTimeDeparture, "Departure time");
	 
	    _oBtnNewScale = new Button("New scale");
	    _oBtnShowScales = new Button("Show Scales");
	    _oScaleLayout.add(_txtPort);
	    add(_oScaleLayout, _oBtnNewScale);
	    
	    oGridScale = new Grid<>();
	    
	    add(oGridScale, _oBtnShowScales);
	    
	}
	    
	    
	    
	    //oGrid.getTreeData().addItems(lstRestaurant.get(0), lstRestaurant);
		 
	
	public ScaleManagement(ScaleRepository oScaleRepo) 
	{	
		_oScaleRepo = oScaleRepo;
		initializeView();
		
		_oBtnNewScale.addClickListener(e->{
			
			
			if(_txtPort.getValue().equals("")
					|| _dtDateDeparture.getValue() == null || _dtDateArrive.getValue() == null)
			{
				Notification.show("Fields are required");
			}
			else
			{
				Scale oS = new Scale();
				oS.setPort(_txtPort.getValue());
				
				smpDateFormatCheck = new SimpleDateFormat();
				_dtArrive = null;
				
				String strMonth = "";
				if(_dtDateArrive.getValue().getMonthValue() < 10) {
					strMonth += "0"+_dtDateArrive.getValue().getMonthValue();
				}
				else {
					strMonth += ""+_dtDateArrive.getValue().getMonthValue();
				}
				
				String sDate = _dtDateArrive.getValue().getDayOfYear() + "/" + _dtDateArrive.getValue().getMonthValue() + "/"
						+ _dtDateArrive.getValue().getYear() + " " +  _dtTimeArrive.getValue().getHour() + ":00:00";
				try {
					_dtArrive = smpDateFormatCheck.parse(sDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				oS.setArrive(_dtArrive);
				
				strMonth = "";
				if(_dtDateDeparture.getValue().getMonthValue() < 10) {
					strMonth += "0"+_dtDateDeparture.getValue().getMonthValue();
				}
				else {
					strMonth += ""+_dtDateDeparture.getValue().getMonthValue();
				}
				sDate = _dtDateDeparture.getValue().getDayOfYear() + "/" + strMonth + "/"
						+ _dtDateDeparture.getValue().getYear() + " " +  _dtTimeDeparture.getValue().getHour() + ":00:00";
				try {
					_dtDeparture = smpDateFormatCheck.parse(sDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				oS.setDeparture(_dtDeparture);
			
				_oScaleRepo.save(oS);
				Notification.show("Scale added to our System.");
			}
		});
		
		_oBtnShowScales.addClickListener(e->{
			List<Scale> oLstRestaurant = _oScaleRepo.escalas();
			
			oGridScale.removeAllColumns();
			oGridScale.setItems(oLstRestaurant);
			oGridScale.addColumn(Scale::getPort).setHeader("Port");
			oGridScale.addColumn(Scale::getArrive).setHeader("Arrive time");
			oGridScale.addColumn(Scale::getDeparture).setHeader("Departure time");
		});
	}
}
