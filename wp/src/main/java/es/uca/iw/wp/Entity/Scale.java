package es.uca.iw.wp.Entity;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Scale {
	@GeneratedValue
	@Id
	private long id;
	private String _sPort;
	//@Temporal(TemporalType.TIMESTAMP)
	private Date _dArrive;
	//@Temporal(TemporalType.TIMESTAMP)
	private Date _dDeparture;
	@CreationTimestamp
	//@Temporal(TemporalType.TIMESTAMP)
	private Date _dTimeNow;
	
	@ManyToOne
	private Trip _oTrip;
	

	public Scale() {}
	
	/**
	 * 
	 * @param iScaleId
	 * @param sPort: Nombre de la ciudad
	 * @param dTimeNow: Horario ahora
	 * @param dArrive: Horario de llegada
	 * @param dDeparture: Horario de salida
	 */
	public Scale(long idScale, String sPort, Date dArrive, Date dDeparture) {
		id = idScale;
		_sPort = sPort;
		_dArrive = dArrive;
		_dDeparture = dDeparture;
	}



	public long getScaleId() {return id;}
	public String getPort() {return _sPort;}
	public Date getArrive() {return _dArrive;}
	public Date getDeparture() {return _dDeparture;}
	
	public void setPort(String sPort) { _sPort = sPort;}
	public void setArrive(Date dArrive) { _dArrive = dArrive;}
	public void setDeparture(Date dDeparture) { _dDeparture = dDeparture;}
	
}
	
