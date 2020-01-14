package es.uca.iw.wp.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
<<<<<<< HEAD
=======
import javax.persistence.ManyToOne;
>>>>>>> 0d3fe9131ea169f14051621d3f7ba37672e6a256
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
	
<<<<<<< HEAD
=======
	@ManyToOne
	private User _oUser;
	
>>>>>>> 0d3fe9131ea169f14051621d3f7ba37672e6a256
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
	
	public int getTipo(){ return _iTipo; }
	public Date getFechaReserva(){ return _dFechaReserva; }
	public double getGasto() { return _dGasto; }
	public int getAforoPosicionUsr() { return _iAforoPosicionUsr; }
	public int getIdTabla( ) {return _iIdTabla; }
	
}
