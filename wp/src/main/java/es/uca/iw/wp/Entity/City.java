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
	private int _iIdScale;
	private String _strDescrip;
	@OneToMany
	private List<Excursion> _lstExcursion = new ArrayList<Excursion>();
}
