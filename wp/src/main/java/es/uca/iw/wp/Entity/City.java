package es.uca.iw.wp.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	private double _dLon;
	private double _dLat;
	public String _sImagePath;
	public String _sUrlVideo;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="_oCity")
	private List<Excursion> _lstExcursion = new ArrayList<Excursion>();
	
	public City() {}
	public City(String sName, String sDescrip, double dLon, double dLat) {
		_sName = sName;
		_sDescrip = sDescrip;
		_dLon = dLon;
		_dLat = dLat;
	}
	
	public String getName() {return _sName;}
	public String getDescrip() {return _sDescrip;}
	public double getLon() {return _dLon;}
	public double getLat() {return _dLat;}
	public String getImagePath() {return _sImagePath;}
	public String getUrlVideo() {return _sUrlVideo;}
	public List<Excursion> getExcursions(){return _lstExcursion;}
	
	public void setCityId(int id) {_iId = id;}
	public void setName(String name) {
		_sName = name;
	}
	
	public void setDescrip(String descrip) {
		_sDescrip = descrip;
	}
	
}
