package es.uca.iw.wp.spring.AdminZone;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import es.uca.iw.wp.Entity.City;
import es.uca.iw.wp.Repository.CityRepository;

@Secured("admin")
public class CityManagement extends VerticalLayout{
	private FormLayout _layout;
	private TextField _txtNameCity;
	private TextField _txtDescription;
	private TextField _txtLon;
	private TextField _txtLat;
	private Grid<City> oGrid;
	private Button _btnSave;
	private Button _btnShow;
	private CityRepository _oCityRepo;
	
	public void initView() {
		_layout = new FormLayout();
		_txtNameCity = new TextField();
		_txtNameCity.setLabel("City");
		
		_txtDescription = new TextField();
		_txtDescription.setLabel("Description of city");
		
		_txtLon = new TextField();
		_txtLon.setLabel("Longitude");
		
		_txtLat = new TextField();
		_txtLat.setLabel("Latitude");
		
		
		_layout.add(_txtNameCity, _txtDescription, _txtLon, _txtLat);
		
		_btnSave = new Button("Save City");
		_btnShow = new Button("Show Cities");
		oGrid = new Grid<>();
		
		add(_layout, _btnSave, _btnShow, oGrid);
	}
	
	public CityManagement(CityRepository oCityRepo) {
		initView();
		
		_oCityRepo = oCityRepo;
		_btnSave.addClickListener(e->{
			City oCity = new City();
			oCity.setName(_txtNameCity.getValue());
			oCity.setDescrip(_txtDescription.getValue());
			oCity.setLon(Float.valueOf(_txtLon.getValue()));
			oCity.setLat(Float.valueOf(_txtLat.getValue()));
			
			_oCityRepo.save(oCity);
			Notification.show("City added to our System");
		});
		
		_btnShow.addClickListener(e->{
			List<City> oLstCity = _oCityRepo.findAll();
			
			oGrid.setItems(oLstCity);
			oGrid.addColumn(City::getName).setHeader("Name");
			oGrid.addColumn(City::getDescrip).setHeader("Description");
			oGrid.addColumn(City::getLon).setHeader("Longitude");
			oGrid.addColumn(City::getLat).setHeader("Latitude");
		});
	}
}
