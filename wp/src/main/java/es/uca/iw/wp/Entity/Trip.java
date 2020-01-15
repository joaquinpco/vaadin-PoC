package es.uca.iw.wp.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trip {

	@GeneratedValue
	@Id
	private Long id;
	
	private String _sName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "_oTrip")
	private List<Scale> oLstScale;
	
	public Trip(){}
	
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
