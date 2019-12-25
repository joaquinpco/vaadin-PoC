package es.uca.iw.wp.Entity;

import java.util.Date;

public class Reserva {

	private int _iTipo;
	private Date _dFechaReserva;
	private double _dGasto;
	private int _iAforoPosicionUsr;
	private int _iIdTabla;
	
	public int getTipo(){ return _iTipo; }
	public Date getFechaReserva(){ return _dFechaReserva; }
	public double getGasto() { return _dGasto; }
	public int getAforoPosicionUsr() { return _iAforoPosicionUsr; }
	public int getIdTabla( ) {return _iIdTabla; }
	
}
