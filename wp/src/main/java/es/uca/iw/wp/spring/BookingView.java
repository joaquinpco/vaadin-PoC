package es.uca.iw.wp.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class BookingView extends VerticalLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7000936254875598952L;
	
	private FormLayout _oLytWithFormItems = new FormLayout();
	private ComboBox<String> _oLblBookingName = new ComboBox<>();
	private TextField _oTxtLastName = new TextField();
	private DatePicker _oDatePicker = new DatePicker();
	private Button _oBtnBook = new Button("Book");
	
	private void initializeView()
	{
		
		_oLblBookingName.setItems("Restaurant", "Excursion");
		_oLblBookingName.setLabel("Booking Name");
		_oLblBookingName.setValue("Restaurant");
		_oLytWithFormItems.add(_oLblBookingName);
		
		_oLytWithFormItems.addFormItem(_oTxtLastName, "Nº Clients");
		_oLytWithFormItems.addFormItem(_oDatePicker, "DD:HH");
		add(_oLytWithFormItems, _oBtnBook);
	}
	
	public BookingView()
	{
		initializeView();
	}
	
}
