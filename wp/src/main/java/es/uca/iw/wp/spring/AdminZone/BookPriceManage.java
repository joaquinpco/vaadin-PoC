package es.uca.iw.wp.spring.AdminZone;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

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
				
				FormLayout oFormLayout = new FormLayout();
				Button oBtnActulizar = new Button("Make Price");
				TextField oTxtId = new TextField("Book Id");
				TextField oTxtPrecio = new TextField("Price");
				
				oFormLayout.add(oTxtId);
				oFormLayout.add(oTxtPrecio);
				
				add(oFormLayout);
				
				add(oBtnActulizar);
				
				oBtnActulizar.addClickListener(e->
				{
					int iId = Integer.valueOf(oTxtId.getValue());
					double dPrice = Double.valueOf(oTxtPrecio.getValue());
					
					Book oBook = _oBookRepository.findById(iId);
					oBook.setGasto(dPrice);
					_oBookRepository.save(oBook);
					Notification.show("Price Updated");
					
					List<Book> oLstBooksUpdate = _oBookRepository.findAll();
					oGrid.removeAllColumns();
					
					oGrid.setItems(oLstBooksUpdate);
					oGrid.addColumn(Book::getId).setHeader("Identificar");
					oGrid.addColumn(Book::getBookUserName).setHeader("Name");
					oGrid.addColumn(Book::getGasto).setHeader("Price");
					
				});
			}
			
		}	
		
		
	}

}
