package es.uca.iw.wp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Trip {

	@GeneratedValue
	@Id
	private Long id;
	
	private String _sName;
	
	
	
	/**
	 * 
	 * @param sName
	 */
	public Trip(String sName)
	{
		_sName = sName;
	}
	
	public String getName() { return _sName; }
	public void setName(String sName) { _sName = sName; }
	
	@Override
	public String toString()
	{
		return getName();
	}
}
