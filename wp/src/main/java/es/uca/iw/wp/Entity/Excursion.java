package es.uca.iw.wp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Excursion {
	@Id
	@GeneratedValue
	private int _iId;
	
	private int _iCityId;
	private String _strExcursionName;
	private String _strDescripcion;
	private double _dPrice;
	private int _iDuracion;
	private double _dCancelationPay;
	
	@ManyToOne
	private Book _oBook;
	
	public Excursion(int iCityId, String strExcursionName, String strDescripcion, double dPrice, int iDuracion, double dCancelationPay) {
		setCityId(_iCityId);
		_strExcursionName = strExcursionName;
		_strDescripcion = strDescripcion;
		_dPrice = dPrice;
		_iDuracion = iDuracion;
		_dCancelationPay = dCancelationPay;
	}
	
	public String getExcursionName() {return _strExcursionName;}
	public String getDescripcion() {return _strDescripcion;}
	public double getPrice() {return _dPrice;}
	public int getDuracion() {return _iDuracion;}
	public double getCancelationPay() {return _dCancelationPay;}
	
	public void setExcursionName(String excName) {_strExcursionName = excName;}
	public void setDescripcion(String desc) {_strDescripcion = desc;}
	public void setPrice(double newPrice) {_dPrice = newPrice;}
	public void setDuracion(int newDuracion) {_iDuracion = newDuracion;}
	public void setCancelationPay(double newCanPay) {_dCancelationPay = newCanPay;}
	public void setCityId(int id) {_iCityId = id;}
}
