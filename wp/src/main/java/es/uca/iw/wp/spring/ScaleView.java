package es.uca.iw.wp.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route("/verEscalas")
public class ScaleView extends VerticalLayout {
	private Button _btnCheck;
	private DatePicker _dBegin, _dEnd;
	private TextField _oTxtNextScale;
	public ScaleView() {
		H1 _hCabecera = new H1("Siguiente escala");
		H2 _hContenido = new H2("a"/*Conexión con la base de datos*/);
		_dBegin = new DatePicker();
		_dBegin.setLabel("Fecha de llegada");
		_dBegin.setPlaceholder("Fecha dentro de la longitud del crucero");
		
		_dEnd = new DatePicker();
		_dEnd.setLabel("Fecha de salida");
		_dEnd.setPlaceholder("Fecha dentro de la longitud del crucero");
		
		_btnCheck = new Button("Comprobar escalas");
		
		FormLayout chooseDates = new FormLayout();
		chooseDates.add(_dBegin, _dEnd, _btnCheck);
		add(_hCabecera, _hContenido, chooseDates);
		_btnCheck.addClickListener(e->Notification.show("Prueba en la parte superior izquierda", 3000, Position.TOP_START)); //Acceso a la base de datos para pillar las escalas entre f1 y f2
	}
}

