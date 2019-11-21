package es.uca.iw.wp.Entity;

import java.time.LocalDateTime;

public class Scale {
	private int _iShipId, _iScaleId;
	private boolean _bFirstCall;
	private String _sPreviousPort, _sNextPort;
	private LocalDateTime _dArrive, _dDeparture;

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
			LocalDateTime dArrive, LocalDateTime dDeparture) {
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
	public LocalDateTime getArrive() {return _dArrive;}
	public LocalDateTime getDeparture() {return _dDeparture;}
	
	public void setScaleId(int iScaleId) { _iScaleId = iScaleId;}
	public void setFirstCall(boolean bFirstCall) { _bFirstCall = bFirstCall;}
	public void setPreviousPort(String sPreviousPort) { _sPreviousPort = sPreviousPort;}
	public void setNextPort(String sNextPort) { _sNextPort = sNextPort;}
	public void setArrive(LocalDateTime dArrive) { _dArrive = dArrive;}
	public void setDeparture(LocalDateTime dDeparture) { _dDeparture = dDeparture;}
	
}
	
