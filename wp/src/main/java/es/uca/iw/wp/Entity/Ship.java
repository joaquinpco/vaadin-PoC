package es.uca.iw.wp.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ship {
	
	@GeneratedValue
	@Id
	private long id;
	
	private String _sName;
	private int _iFlats;
	private int _iStars;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> _lstUser;
	
	public Ship() {}
	
	/**
	 * 
	 * @param iFlats
	 * @param iStars
	 * @param sName
	 */
	public Ship(int iFlats, int iStars, String sName)
	{
		_iFlats = iFlats;
		_iStars = iStars;
		_sName = sName;
	}
	
	/**
	 * Add user to list
	 * @Param oUser user to added
	 */
	public void addUser(User oUser)
	{
		if(_lstUser == null)
			_lstUser = new ArrayList<User>();
		
		_lstUser.add(oUser);
	}
	
	public int getFlats() { return _iFlats; }
	public int getStars() { return _iStars; }
	public String getName() { return _sName; }
	
	public void setName(String sName) {_sName = sName;}
	public void setFlats(int iFlats) { _iFlats = iFlats; }
	public void setStars(int iStars) { _iStars = iStars; }
}
