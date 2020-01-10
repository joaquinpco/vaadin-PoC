package es.uca.iw.wp.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import es.uca.iw.wp.Entity.Excursion;
import es.uca.iw.wp.Services.ExcursionService;


@Secured({"admin", "user"})
public class ExcursionView extends VerticalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6948443102161050082L;

	@Autowired
	private ExcursionService _oExSvc;
	
	private H1 _h1NombreExc, _h1NoExcursionData;
	private Paragraph _pDescExc;
	private Button _btnExcCiudad;
	private HorizontalLayout priceInfo = new HorizontalLayout();
	
	public ExcursionView(ExcursionService oExSvc) 
	{
		_oExSvc =  oExSvc;
	
		if(_oExSvc.count() > 0 )
		{
			Excursion ex = _oExSvc.findByIds(0);
			_h1NombreExc = new H1(ex.getExcursionName());
			_pDescExc = new Paragraph(ex.getDescription());
			priceInfo.add(new Span(ex.getPrice() + "€\n" + "Duration = " + ex.getDuration() + " min"));
			
			add(_h1NombreExc, _pDescExc, priceInfo);
		}
		else
		{
			_h1NoExcursionData = new H1("No hay datos de excursiones actualmente");
			add(_h1NoExcursionData);
		}
		
	}
}
