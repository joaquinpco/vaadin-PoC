package es.uca.iw.wp.Entity;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private Long id;
	
	private String _sName;
	private Date _dtOpen, _dtClose;
	
	//private List of food many to many
	@OneToMany
	private List<Food> _lstFood = new ArrayList<Food>();
	
	public String getName() { return _sName;}
	public void setName(String name) {_sName = name;}
	public Date getOpen() {return _dtOpen;}
	public void setOpen(Date timeOpen) {_dtOpen = timeOpen;}
	public Date getClose() {return _dtClose;}
	public void setClose(Date timeClose) {_dtClose = timeClose;}
	public void addFood(Food plate) { _lstFood.add(plate);}
	public void addFood(String name, float price) { Food plate = new Food(name , price); _lstFood.add(plate);}
	/*
	public String getNameFood(int i) { return _lstFood.;}
	public void setNameFood(int i, String name) {_lstFood.get(i).setName(name);}
	public float getPriceFood(int i) {return _lstFood.get(i).getPrice();}
	public void setPriceFood(int i, float price) {_lstFood.get(i).setPrice(price);}
	*/
}
