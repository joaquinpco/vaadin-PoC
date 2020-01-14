package es.uca.iw.wp.Entity;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private Long id;
	
	private String _sName;
	private Date _dtOpen, _dtClose;
	private int _iNumerOfTables;
	
	//private List of food many to many
	@OneToMany(fetch=FetchType.EAGER)
	private List<Food> _lstFood = new ArrayList<Food>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Book _oBook;
	
	public Restaurant() {}
	
	public Restaurant(String name, Date open, Date close, int tables){
		_sName=name;
		_dtOpen=open;
		_dtClose=close;
		_iNumerOfTables=tables;
	}
	public List<Food> getFoods(){ return _lstFood; }
	public String getName() { return _sName;}
	public void setName(String sName) {_sName = sName;}
	public Date getOpen() {return _dtOpen;}
	public void setOpen(Date dtTimeOpen) {_dtOpen = dtTimeOpen;}
	public Date getClose() {return _dtClose;}
	public void setClose(Date dtTimeClose) {_dtClose = dtTimeClose;}
	public int getTable() {return _iNumerOfTables;}
	public Long getId() {return id;}
	public void setTable(int iNumTables) {_iNumerOfTables = iNumTables;}
	public void addFood(Food oPlate) { _lstFood.add(oPlate);}
	public void addFood(Long lIdRestaurant, String sName, float fPrice) { Food oPlate = new Food(sName , fPrice); _lstFood.add(oPlate);}
	/*
	public String getNameFood(int i) { return _lstFood.;}
	public void setNameFood(int i, String name) {_lstFood.get(i).setName(name);}
	public float getPriceFood(int i) {return _lstFood.get(i).getPrice();}
	public void setPriceFood(int i, float price) {_lstFood.get(i).setPrice(price);}
	*/
}
