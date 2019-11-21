package es.uca.iw.wp.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private Long id;
	private String _sName;
	private Date _dtOpen, _dtClose;
	//private List
	private List<Food> _lstFood;
	
	private class Food
	{
		private String _sName;
		private float _fPrice;
		
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
		public void setName(String name) {_sName = name;}
		public Date getOpen() {return _dtOpen;}
		public void setOpen(Date timeOpen) {_dtOpen = timeOpen;}
		public Date getClose() {return _dtClose;}
		public void setClose(Date timeClose) {_dtClose = timeClose;}
		public void addFood(Food plate) { _lstFood.add(plate);}
		public void addFood(String name, float price) { Food plate = new Food(name , price); _lstFood.add(plate);}
		public float getPrice() {return _fPrice;}
		public void setPrice(float price) {_fPrice = price;}
	}
}
