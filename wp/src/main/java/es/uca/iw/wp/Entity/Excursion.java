package es.uca.iw.wp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Excursion {
	@Id
	@GeneratedValue
	
	private int _iId;
	private String _strExcursionName;
	private String _strDescripcion;
	private double _dPrice;
}
