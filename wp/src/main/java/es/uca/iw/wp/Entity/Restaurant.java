package es.uca.iw.wp.Entity;

import java.util.Date;
import java.util.List;

public class Restaurant {
	
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
			_fPrice = fPrice;
		}
	}
}
