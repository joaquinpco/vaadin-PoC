package es.uca.iw.wp.spring;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import es.uca.iw.wp.Entity.Scale;
import es.uca.iw.wp.Services.ScaleService;
//Prueba
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
	private VerticalLayout _oMainContainer;
	private H1 _oTxtInfo;
	
	private SimpleDateFormat _oDateF = new SimpleDateFormat("dd-MM-yyyy");

	
	private Accordion _oAcrdnScales;
	private Accordion _oAcrdnList;
	
	private VerticalLayout _oVrtlHorario;
	private VerticalLayout _oVrtlCiudad;
	private VerticalLayout _oVrtlNewScale;
	
	public ScaleView(ScaleService oScService) {
		_oScService = oScService;
		
		_oAcrdnList = new Accordion();
		
		long iCount = _oScService.numberOfScales();
		
		List<Scale> oLst = _oScService.escalas();
		Iterator<Scale> oIter = oLst.iterator();
		
		if(iCount > 0)
		{
			while(oIter.hasNext()) {
				Scale oS = oIter.next();
				_oVrtlHorario = new VerticalLayout();
				_oVrtlCiudad = new VerticalLayout();
				_oVrtlNewScale = new VerticalLayout();
				_oAcrdnScales = new Accordion();
				if(oS.getScaleId() == 0) {
					_oVrtlHorario.add(new Span("Horario de salida = " + _oDateF.format(oS.getDeparture())));
				}
				else {
					_oVrtlHorario.add(
							new Span("Horario de llegada = " + _oDateF.format(oS.getArrive())),
						new Span("Horario de salida = " + _oDateF.format(oS.getDeparture())));

				}
				_oAcrdnScales.add("Horario", _oVrtlHorario);
				
				_oVrtlCiudad.add(new Span("Visitaremos " + oS.getPort()));
				
				_oAcrdnScales.add("Ciudad", _oVrtlCiudad);
				
				_oVrtlNewScale.add(_oAcrdnScales);
				_oAcrdnList.add(oS.getPort(), _oVrtlNewScale);
			}
			add(_oAcrdnList);
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