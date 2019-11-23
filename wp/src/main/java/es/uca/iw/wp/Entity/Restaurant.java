package es.uca.iw.wp.Entity;

import java.util.Date;

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
	
	
}
