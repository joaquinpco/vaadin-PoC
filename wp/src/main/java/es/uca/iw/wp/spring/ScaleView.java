package es.uca.iw.wp.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import es.uca.iw.wp.Entity.Scale;
import es.uca.iw.wp.Services.ScaleService;

@Secured({"user","admin"})
public class ScaleView extends VerticalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4995444170616023933L;

	@Autowired
	private ScaleService _oScService;
	
	private Button _btnCheck;
	private Button _btnGoToCity;
	private DatePicker _dBegin, _dEnd;
	private H1 _oTxtInfo;
	
	public ScaleView(ScaleService _oScService) {
		this._oScService = _oScService;
		
		long iCount  =  _oScService.numberOfScales();
		
		if(iCount > 0)
		{
			Scale s = _oScService.findById(0);
			
			H1 _hCabecera = new H1("Escala: " + s.getPort());
			_btnGoToCity = new Button("Ver información de " + s.getPort());
			_btnGoToCity.addClickListener(e->{
				_btnGoToCity.getUI().ifPresent(ui->ui.navigate("showCity"));//Con esto, se hace como un href a showCity
			}
			);
			
			H2 _hContenido = new H2("Siguiente escala -> ");
			_dBegin = new DatePicker();
			_dBegin.setLabel("Fecha de llegada");
			_dBegin.setPlaceholder("Fecha dentro de la longitud del crucero");
			
			_dEnd = new DatePicker();
			_dEnd.setLabel("Fecha de salida");
			_dEnd.setPlaceholder("Fecha dentro de la longitud del crucero");
			
			_btnCheck = new Button("Comprobar escalas");
			
			FormLayout chooseDates = new FormLayout();
			chooseDates.add(_dBegin, _dEnd, _btnCheck);
			add(_hCabecera, _btnGoToCity, _hContenido, chooseDates);
		}
		else
		{
			_oTxtInfo = new H1("No hay datos de escalas actualmente");
			add(_oTxtInfo);
		}
		//_btnCheck.addClickListener(e->obtainTable(_dBegin.getValue(), _dEnd.getValue())); //Acceso a la base de datos para pillar las escalas entre f1 y f2
	}
	/*private void obtainTable(LocalDate dArrive, LocalDate dDeparture) {
		List<Scale> listScale = _oScService.findAllByScaleTimeBetween(dArrive, dDeparture);
		Grid<Scale> grid = new Grid<>();
		grid.setItems(listScale);
		grid.addColumn(Scale::getPort).setHeader("Ciudad");
		grid.addColumn(Scale::getArrive).setHeader("Entrada al puerto");
		grid.addColumn(Scale::getDeparture).setHeader("Salida del puerto");
		add(grid);
	}
	*/
}