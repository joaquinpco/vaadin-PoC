package es.uca.iw.wp.Entity;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Scale {
	@GeneratedValue
	@Id
	private int _iScaleId;
	private String _sPort;
	private LocalTime _dTimeNow;
	private LocalTime _dArrive;
	private LocalTime _dDeparture;

	public Scale() {}
	
	/**
	 * 
	 * @param iScaleId
	 * @param sPort: Nombre de la ciudad
	 * @param dTimeNow: Horario ahora
	 * @param dArrive: Horario de llegada
	 * @param dDeparture: Horario de salida
	 */
	public Scale(int iScaleId, String sPort,
			LocalTime dTimeNow, LocalTime dArrive, LocalTime dDeparture) {
		_iScaleId = iScaleId;
		_sPort = sPort;
		_dArrive = dArrive;
		_dDeparture = dDeparture;
		_dTimeNow = dTimeNow;
	}



	public int getScaleId() {return _iScaleId;}
	public String getPort() {return _sPort;}
	public LocalTime getTimeNow() {return _dTimeNow;}
	public LocalTime getArrive() {return _dArrive;}
	public LocalTime getDeparture() {return _dDeparture;}
	
	public void setScaleId(int iScaleId) { _iScaleId = iScaleId;}
	public void setPort(String sPort) { _sPort = sPort;}
	public void setArrive(LocalTime dArrive) { _dArrive = dArrive;}
	public void setDeparture(LocalTime dDeparture) { _dDeparture = dDeparture;}
	public void setTimeNow(LocalTime dTimeNow) {_dTimeNow = dTimeNow;}
}
	
