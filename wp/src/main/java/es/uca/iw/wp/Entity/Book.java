package es.uca.iw.wp.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private int id;
	
	private int _iTipo;
	private Date _dFechaReserva;
	private double _dGasto;
	private int _iAforoPosicionUsr;
	private int _iIdTabla;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "_oBook")
	private List<Restaurant> _oLstRestaurant = new ArrayList<Restaurant>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "_oBook")
	private List<Excursion> _oLstExcursion = new ArrayList<Excursion>();

	@ManyToOne
	private User _oUser;
	
	public Book(){}
	
	/**
	 * 
	 * @param id
	 * @param iTipo
	 * @param dFechaReserva
	 * @param dGasto
	 * @param iAforoPosicionUsr
	 * @param iIdTabla
	 */
	public Book(int id, int iTipo, Date dFechaReserva, 
			double dGasto, int iAforoPosicionUsr, int iIdTabla)
	{
		_iTipo = iTipo;
		_dFechaReserva = dFechaReserva;
		_dGasto = dGasto;
		_iAforoPosicionUsr = iAforoPosicionUsr;
		_iIdTabla = iIdTabla;
	}
	
	public int getId() { return id; }
	public int getTipo(){ return _iTipo; }
	public Date getFechaReserva(){ return _dFechaReserva; }
	public double getGasto() { return _dGasto; }
	public int getAforoPosicionUsr() { return _iAforoPosicionUsr; }
	public int getIdTabla( ) {return _iIdTabla; }
	
	public void setTipo(int iTipo) { _iTipo = iTipo; }
	public void setFechaReserva(Date dFechaReserva){ _dFechaReserva = dFechaReserva; }
	public void setGasto(double dGasto){ _dGasto= dGasto; }
	
	public String getBookUserName() { return _oUser.getName() + " " + _oUser.getLastName();}
	
	//Book user table  
	public void setAforoPosicionUser(int iAforoPosicionUsr) { _iAforoPosicionUsr = iAforoPosicionUsr; }
	
	//1 Restaurants 2 Excursions
	public void setIdTabla(int iIdTabla) { _iIdTabla = iIdTabla; }
	
	public void setBookUser(User oUser) { _oUser = oUser; }
	
	
	
	
}
