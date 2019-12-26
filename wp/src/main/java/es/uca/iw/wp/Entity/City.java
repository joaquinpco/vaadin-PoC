package es.uca.iw.wp.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class City {
	@GeneratedValue
	@Id
	private int _iId;
	
	private String _sName;
	private String _sDescrip;
	@OneToMany
	private List<Excursion> _lstExcursion = new ArrayList<Excursion>();
	public City() {}
	public City(String sName, String sDescrip) {
		_sName = sName;
		_sDescrip = sDescrip;
	}
	
	public String getName() {return _sName;}
	public String getDescrip() {return _sDescrip;}
	
	public void setCityId(int id) {_iId = id;}
	public void setName(String name) {
		_sName = name;
	}
	
	public void setDescrip(String descrip) {
		_sDescrip = descrip;
	}
}
