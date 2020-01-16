package es.uca.iw.wp.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Excursion {
	@Id
	@GeneratedValue
	private Long id;
	
	private String _strExcursionName;
	private String _strDescription;
	private double _dPrice;
	private int _iDuration;
	private double _dCancelationPay;
	
	@ManyToOne
	private City _oCity;
	
	@ManyToOne
	private Book _oBook;
	
	public Excursion() {}
	
	public Excursion(String strExcursionName, String strDescription, double dPrice, int iDuration, double dCancelationPay) {
		_strExcursionName = strExcursionName;
		_strDescription = strDescription;
		_dPrice = dPrice;
		_iDuration = iDuration;
		_dCancelationPay = dCancelationPay;
	}
	
	public String getExcursionName() {return _strExcursionName;}
	public String getDescription() {return _strDescription;}
	public double getPrice() {return _dPrice;}
	public int getDuration() {return _iDuration;}
	public double getCancelationPay() { return _dCancelationPay; }
	public Long getId() {return id;}
	
	public void setExcursionName(String excName) {_strExcursionName = excName;}
	public void setDescription(String desc) {_strDescription = desc;}
	public void setPrice(double newPrice) {_dPrice = newPrice;}
	public void setDuration(int newDuration) {_iDuration = newDuration;}
	public void setCancelationPay(double dCancelationPay) { _dCancelationPay = dCancelationPay; }
}
