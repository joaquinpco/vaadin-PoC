package es.uca.iw.wp.spring;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import es.uca.iw.wp.Entity.Excursion;
import es.uca.iw.wp.Services.ExcursionService;

@Route("getExcursions")
public class ExcursionView extends VerticalLayout {
	
	@Autowired
	private ExcursionService _oExSvc;
	
	private H1 _hNombreExc;
	private Paragraph _pDescExc;
	private Button _btnExcCiudad;
	private HorizontalLayout priceInfo = new HorizontalLayout();
	public ExcursionView(ExcursionService oExSvc) {
		_oExSvc =  oExSvc;
		Excursion ex = _oExSvc.findByIds(0);
		_hNombreExc = new H1(ex.getExcursionName());
		_pDescExc = new Paragraph(ex.getDescription());
		priceInfo.add(new Span(ex.getPrice() + "€\n" + "Duration = " + ex.getDuration() + " min"));
		
		add(_hNombreExc, _pDescExc, priceInfo);
		
	}
}
