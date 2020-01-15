package es.uca.iw.wp.spring;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import es.uca.iw.wp.Entity.Book;
import es.uca.iw.wp.Entity.User;
import es.uca.iw.wp.Repository.BookRepository;
import es.uca.iw.wp.Security.SecurityUtils;

@Secured({"user", "admin"})
public class UserView extends VerticalLayout{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5073527090749853594L;
	private Button _oBtnMyBooks;
	private BookRepository _oBookRepository;
	private Grid<Book> oGrid;
	
	public UserView(BookRepository oBookRepository)
	{
		_oBookRepository = oBookRepository;
		
		User oUser = SecurityUtils.getSesionUser();
		
		H2 h2Name = new H2("Name: " + oUser.getName());
		
		H2 h2LastName = new H2("Last Name:" + oUser.getLastName());
		
		_oBtnMyBooks = new Button("My Books");
		
		add(h2Name, h2LastName, _oBtnMyBooks);
		
		VerticalLayout oCurrentLayout = this;
		
		_oBtnMyBooks.addClickListener(e->{
			
			oCurrentLayout.removeAll();
			
			oGrid = new Grid<>();
			
			oGrid.removeAllColumns();
			
			if( _oBookRepository.count() > 0)
			{
				List<Book> oLstBooks = _oBookRepository.findByUsers(oUser);
				
				//Only showed if there is at least one.
				if(oLstBooks.size() > 0)
				{
				
					oGrid.setItems(oLstBooks);
					oGrid.addColumn(Book::getFechaReserva).setHeader("Fecha Reserva");
					oGrid.addColumn(Book::getAforoPosicionUsr).setHeader("Aforo");
					oGrid.addColumn(Book::getTipo).setHeader("Tipo");
					oCurrentLayout.add(oGrid);
					
				}
				
			}	
			
		});
	}
}
