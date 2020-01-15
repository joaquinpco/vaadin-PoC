package es.uca.iw.wp.spring;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import es.uca.iw.wp.Entity.Excursion;
import es.uca.iw.wp.Repository.BookRepository;
import es.uca.iw.wp.Services.ExcursionService;


@Secured({"admin", "user"})
public class ExcursionView extends VerticalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6948443102161050082L;

	@Autowired
	private ExcursionService _oExSvc;
	
	private BookRepository _oBookRep;
	
	private H1 _h1NoExcursionData;
	
	private VerticalLayout _oDescripcion;
	private VerticalLayout _oMainContainer;
	private VerticalLayout _oPrecios;
	private VerticalLayout _oNewExcursion;
	
	private Accordion _oAcrdnList;
	private Accordion _oAcrdnExcursions;
	public ExcursionView(ExcursionService oExSvc, BookRepository oBookRep) 
	{
		_oMainContainer = this;
		_oExSvc =  oExSvc;
		_oBookRep = oBookRep;
		List<Excursion> excursiones = _oExSvc.listExcursion();
		Iterator<Excursion> iterExcursion = excursiones.iterator();
		_oAcrdnList = new Accordion();
		if(_oExSvc.count() > 0 )
		{
			while(iterExcursion.hasNext()) {
				Excursion oExc = iterExcursion.next();
				_oDescripcion = new VerticalLayout();
				
				_oPrecios = new VerticalLayout();
				_oNewExcursion = new VerticalLayout();
				_oAcrdnExcursions = new Accordion();
				
				_oDescripcion.add(
						new Span("Descripción: " + oExc.getDescription()),
						new Span("Duración: " + oExc.getDuration() + " min")
				);
				_oAcrdnExcursions.add("Descripcion", _oDescripcion);
				
				_oPrecios.add(new Span("Precio: " + oExc.getPrice()),
						new Span("En caso de cancelar la reserva tendrá que pagar: " + oExc.getCancelationPay()));
				_oAcrdnExcursions.add("Precio", _oPrecios);
				
				Button reserva = new Button("Pulse aquí");
				_oAcrdnExcursions.add("Reserve ahora", reserva);
				
				reserva.addClickListener(e->{
					Long iIdExcursion = oExc.getId();
					_oMainContainer.removeAll();
					_oMainContainer.add(new BookingView("Excursion", oExSvc, iIdExcursion, _oBookRep));
				});
				
				_oNewExcursion.add(_oAcrdnExcursions);
				_oAcrdnList.add(oExc.getExcursionName(), _oNewExcursion);
			}
			add(_oAcrdnList);
		}
		else
		{
			_h1NoExcursionData = new H1("No hay datos de excursiones actualmente");
			add(_h1NoExcursionData);
		}
		
	}
}
