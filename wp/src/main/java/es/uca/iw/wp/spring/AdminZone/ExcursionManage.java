package es.uca.iw.wp.spring.AdminZone;

import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import es.uca.iw.wp.Entity.Excursion;
import es.uca.iw.wp.Repository.ExcursionRepository;

public class ExcursionManage extends VerticalLayout{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8613023743986289489L;
	
	private FormLayout _oColumnLayout;
	private TextField _txtExcursionName, _txtDescriptionName,_txtPrice ,_txtDuration ,_txtCancelationPay;
	private Button _oBtnNewExcursion, _oBtnShowExcursions;
	private Grid<Excursion> oGrid;
	
	private ExcursionRepository _oExcursionRepository;
	
	
	private void initializeView()
	{
		_oColumnLayout = new FormLayout();
		// Setting the desired responsive steps for the columns in the layout
		_oColumnLayout.setResponsiveSteps(
		           new ResponsiveStep("25em", 1),
		           new ResponsiveStep("32em", 2),
		           new ResponsiveStep("40em", 3));
		
		_txtExcursionName = new TextField();
	    _txtExcursionName.setPlaceholder("Name");
	    _txtDescriptionName = new TextField();
	    _txtDescriptionName.setPlaceholder("Description");
	    _txtPrice = new TextField();
	    _txtPrice.setPlaceholder("Price");
	    _txtDuration = new TextField();
	    _txtDuration.setPlaceholder("Duration");
	    _txtCancelationPay = new TextField();
	    _txtCancelationPay.setPlaceholder("Cancelation Pay");
	    
	    _oBtnNewExcursion = new Button("Register");
	    _oBtnShowExcursions = new Button("Show Excursions");
	    
	    oGrid = new Grid<>();
	    
	    
	    
	    //oGrid.getTreeData().addItems(lstExcursion.get(0), lstExcursion);
		   
	    _oColumnLayout.add(_txtExcursionName, _txtDescriptionName,_txtPrice ,_txtDuration ,_txtCancelationPay);
	    add(_oColumnLayout, _oBtnNewExcursion, oGrid, _oBtnShowExcursions);
	}
	
	public ExcursionManage(ExcursionRepository oExcursionRepository) 
	{
		initializeView();
		
		_oExcursionRepository = oExcursionRepository;
		
		_oBtnNewExcursion.addClickListener(e->{
			Excursion oExcursion = new Excursion();
			oExcursion.setExcursionName(_txtExcursionName.getValue());
			oExcursion.setDescription(_txtDescriptionName.getValue());
			oExcursion.setPrice(Float.valueOf(_txtPrice.getValue()));
			oExcursion.setDuration(Integer.valueOf(_txtDuration.getValue()));
			oExcursion.setCancelationPay(Float.valueOf(_txtCancelationPay.getValue()));
			
			_oExcursionRepository.save(oExcursion);
			Notification.show("Excursion added to our System.");
		});
		
		_oBtnShowExcursions.addClickListener(e->{
			List<Excursion> oLstExcursion = _oExcursionRepository.findAll();
			
			oGrid.removeAllColumns();
			
			oGrid.setItems(oLstExcursion);
			oGrid.addColumn(Excursion::getExcursionName).setHeader("Name");
			oGrid.addColumn(Excursion::getDescription).setHeader("Description");
			oGrid.addColumn(Excursion::getDescription).setHeader("Price");
			oGrid.addColumn(Excursion::getDescription).setHeader("Duration");
			oGrid.addColumn(Excursion::getDescription).setHeader("Cancelation Pay");
			//oGrid.getTreeData().addItems(oLstExcursion.get(0), oLstExcursion);
		});
	}
	
}
