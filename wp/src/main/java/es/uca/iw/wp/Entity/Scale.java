package es.uca.iw.wp.Entity;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Scale {
	@GeneratedValue
	@Id
	private int _iScaleId;
	private String _sPort;
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDate _dArrive;
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDate _dDeparture;
	@CreationTimestamp
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDate _dTimeNow;
	

	public Scale() {}
	
	/**
	 * 
	 * @param iScaleId
	 * @param sPort: Nombre de la ciudad
	 * @param dTimeNow: Horario ahora
	 * @param dArrive: Horario de llegada
	 * @param dDeparture: Horario de salida
	 */
	public Scale(int iScaleId, String sPort, LocalDate dArrive, LocalDate dDeparture) {
		_iScaleId = iScaleId;
		_sPort = sPort;
		_dArrive = dArrive;
		_dDeparture = dDeparture;
		_dTimeNow = LocalDate.now();
	}



	public int getScaleId() {return _iScaleId;}
	public String getPort() {return _sPort;}
	public LocalDate getArrive() {return _dArrive;}
	public LocalDate getDeparture() {return _dDeparture;}
	
	public void setScaleId(int iScaleId) { _iScaleId = iScaleId;}
	public void setPort(String sPort) { _sPort = sPort;}
	public void setArrive(LocalDate dArrive) { _dArrive = dArrive;}
	public void setDeparture(LocalDate dDeparture) { _dDeparture = dDeparture;}
	
}
	
