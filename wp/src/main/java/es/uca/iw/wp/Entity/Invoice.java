package es.uca.iw.wp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Invoice 
{
	@GeneratedValue
	@Id
	private long id;
	private String _sDescription;
	private double _dExpenses;
	
	@ManyToOne
	private User _oUser;
	
	public Invoice() {}
	
	/**
	 * 
	 * @param sDescription
	 * @param dExpenses
	 */
	public Invoice(String sDescription, double dExpenses)
	{
		_sDescription = sDescription;
		_dExpenses = dExpenses;
	}
	
	public String getDescription() { return _sDescription; }
	public double getExpenses() { return _dExpenses; }
	public void setExpenses(double dExpenses) { _dExpenses = dExpenses; }
	public void setDescription(String sDescription) { _sDescription = sDescription; }
}
