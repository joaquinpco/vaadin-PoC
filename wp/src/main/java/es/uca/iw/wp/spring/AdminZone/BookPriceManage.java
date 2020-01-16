package es.uca.iw.wp.spring.AdminZone;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import es.uca.iw.wp.Entity.Book;
import es.uca.iw.wp.Repository.BookRepository;

@Secured({"manager", "admin"})
public class BookPriceManage extends VerticalLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6292007670752581495L;
	
	private BookRepository _oBookRepository;
	
	
	public BookPriceManage(BookRepository oBookRepository)
	{
		_oBookRepository = oBookRepository;
		
		removeAll();
		
		Grid<Book> oGrid = new Grid<>();
		
		oGrid.removeAllColumns();
		
		if( _oBookRepository.count() > 0)
		{
			List<Book> oLstBooks = _oBookRepository.findAll();
			
			//Only showed if there is at least one.
			if(oLstBooks.size() > 0)
			{
			
				oGrid.setItems(oLstBooks);
				oGrid.addColumn(Book::getId).setHeader("Identificar");
				oGrid.addColumn(Book::getBookUserName).setHeader("Name");
				oGrid.addColumn(Book::getGasto).setHeader("Price");
				
				add(oGrid);
				
			}
			
		}	
		
		
	}

}
