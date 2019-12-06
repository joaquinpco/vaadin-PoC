package es.uca.iw.wp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Food
{
	@Id
	@GeneratedValue
	private Long id;
	
	private String _sName;
	private float _fPrice;
	
	public Food() {}
	/**
	 * 
	 * @param sName
	 * @param fPrice
	 */
	public Food(String sName, float fPrice)
	{
		_sName = sName;
		setPrice(fPrice);
	}
	
	public String getName() { return _sName;}
	public void setName(String sName) {_sName = sName;}
	public float getPrice() {return _fPrice;}
	public void setPrice(float fPrice) {_fPrice = fPrice;}
}