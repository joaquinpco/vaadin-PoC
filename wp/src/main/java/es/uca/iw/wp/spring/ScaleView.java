package es.uca.iw.wp.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;



public class ScaleView extends VerticalLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1820114367662698117L;
	
	private Button _btnCheck;
	private DatePicker _dBegin, _dEnd;
	
	public ScaleView() {
		_dBegin = new DatePicker();
		_dBegin.setLabel("Fecha de llegada");
		_dBegin.setPlaceholder("Fecha dentro de la longitud del crucero");
		
		_dEnd = new DatePicker();
		_dEnd.setLabel("Fecha de salida");
		_dEnd.setPlaceholder("Fecha dentro de la longitud del crucero");
		
		_btnCheck = new Button("Comprobar escalas");
		
		HorizontalLayout chooseDates = new HorizontalLayout(_dBegin, _dEnd, _btnCheck);
		_btnCheck.addClickListener(e->checkScale());
	}
	private Object checkScale() {
		// TODO Auto-generated method stub
		return null;
	}
}
