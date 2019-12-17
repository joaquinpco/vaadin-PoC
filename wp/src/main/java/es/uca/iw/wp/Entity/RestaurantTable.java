package es.uca.iw.wp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RestaurantTable
{
	@Id
	@GeneratedValue
	private Long id;
	
	private int _iNumber;
	private Long _lUserId;
	
	public RestaurantTable() {}
	/**
	 * 
	 * @param sNumber
	 * @param lUserId
	 */
	public RestaurantTable(int iNumber, Long lUserId)
	{
		_iNumber = iNumber;
		setUserId(lUserId);
	}
	
	public int getNumber() { return _iNumber;}
	public void setNumber(int iNumber) {_iNumber = iNumber;}
	public Long getUserId() {return _lUserId;}
	public void setUserId(Long lUserId) {_lUserId = lUserId;}
}