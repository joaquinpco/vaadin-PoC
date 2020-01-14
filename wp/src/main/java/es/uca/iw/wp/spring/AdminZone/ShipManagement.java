package es.uca.iw.wp.spring.AdminZone;

import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import es.uca.iw.wp.Entity.Ship;
import es.uca.iw.wp.Repository.ShipRepository;

public class ShipManagement extends VerticalLayout{
	private FormLayout _oShipLayout;
	private TextField _txtName;
	private TextField _txtFlats;
	private TextField _txtStars;
	
	private Button _btnSaveShip;
	private Button _btnShowShips;
	
	private Grid<Ship> _oGridShips;
	
	private ShipRepository _oShipRepo;
	
	public void initView() {
		_oShipLayout = new FormLayout();
		
		_txtName = new TextField();
		_txtName.setLabel("Name of the ship");
		_txtName.setPlaceholder("Ship's name");
		
		_txtFlats = new TextField();
		_txtFlats.setLabel("Flats of the ship");
		_txtFlats.setPlaceholder("Number of flats");
		
		_txtStars = new TextField();
		_txtStars.setLabel("Stars of the ship");
		_txtStars.setPlaceholder("1 - 5");
		
		_oShipLayout.add(_txtName, _txtFlats, _txtStars);
		
		_btnSaveShip = new Button("Save ship");
		_btnShowShips = new Button("Show Ships");
		
		_oGridShips = new Grid<>();
		
		
		add(_oShipLayout, _btnSaveShip, _btnShowShips, _oGridShips);
	}
	
	public ShipManagement(ShipRepository oShipRepo) {
		initView();
		
		_oShipRepo = oShipRepo;
		
		_btnSaveShip.addClickListener(e->{
			Ship _oShip = new Ship();
			_oShip.setName(_txtName.getValue());
			_oShip.setFlats(Integer.valueOf(_txtFlats.getValue()));
			_oShip.setStars(Integer.valueOf(_txtStars.getValue()));
			_oShipRepo.save(_oShip);
			Notification.show("Ship added to our System");
		});
		
		_btnShowShips.addClickListener(e->{
			List<Ship> oLstShip = _oShipRepo.findAll();
			
			_oGridShips.setItems(oLstShip);
			_oGridShips.addColumn(Ship::getName).setHeader("Name");
			_oGridShips.addColumn(Ship::getFlats).setHeader("Flats");
			_oGridShips.addColumn(Ship::getStars).setHeader("Stars");
		});
	}
}
