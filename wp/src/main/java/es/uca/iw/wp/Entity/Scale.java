package es.uca.iw.wp.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Scale {
	@GeneratedValue
	@Id
	private int _iScaleId;
	private int _iShipId;
	private boolean _bFirstCall;
	private String _sPreviousPort, _sNextPort;
	private Date _dArrive, _dDeparture;

	public Scale() {}
	
	/**
	 * 
	 * @param iShipId
	 * @param iScaleId
	 * @param bFirstCall
	 * @param sPreviousPort
	 * @param sNextPort
	 * @param dArrive
	 * @param dDeparture
	 */
	public Scale(int iShipId, int iScaleId, boolean bFirstCall, String sPreviousPort, String sNextPort,
			Date dArrive, Date dDeparture) {
		_iShipId = iShipId;
		_iScaleId = iScaleId;
		_bFirstCall = bFirstCall;
		_sPreviousPort = sPreviousPort;
		_sNextPort = sNextPort;
		_dArrive = dArrive;
		_dDeparture = dDeparture;
	}



	public int getShipId() {return _iShipId;}
	public int getScaleId() {return _iScaleId;}
	
	public boolean isFirstCall() {return _bFirstCall;}
	public void setShipId(int iShipId) { _iShipId = iShipId;}
	public String getPreviousPort() {return _sPreviousPort;}
	public String getNextPort() {return _sNextPort;}
	public Date getArrive() {return _dArrive;}
	public Date getDeparture() {return _dDeparture;}
	
	public void setScaleId(int iScaleId) { _iScaleId = iScaleId;}
	public void setFirstCall(boolean bFirstCall) { _bFirstCall = bFirstCall;}
	public void setPreviousPort(String sPreviousPort) { _sPreviousPort = sPreviousPort;}
	public void setNextPort(String sNextPort) { _sNextPort = sNextPort;}
	public void setArrive(Date dArrive) { _dArrive = dArrive;}
	public void setDeparture(Date dDeparture) { _dDeparture = dDeparture;}
	
}
	