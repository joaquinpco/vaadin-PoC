package Models;

import java.time.LocalDateTime;

public class Scale {
	private int _iShipId, _iScaleId;
	private boolean _bFirstCall;
	private String _sPreviousPort, _sNextPort;
	private LocalDateTime _dArrive, _dDeparture;

	public Scale() {}
	
	public Scale(int _iShipId, int _iScaleId, boolean _bFirstCall, String _sPreviousPort, String _sNextPort,
			LocalDateTime _dArrive, LocalDateTime _dDeparture) {
		this._iShipId = _iShipId;
		this._iScaleId = _iScaleId;
		this._bFirstCall = _bFirstCall;
		this._sPreviousPort = _sPreviousPort;
		this._sNextPort = _sNextPort;
		this._dArrive = _dArrive;
		this._dDeparture = _dDeparture;
	}



	public int get_iShipId() {return _iShipId;}
	public int get_iScaleId() {return _iScaleId;}
	
	public boolean is_bFirstCall() {return _bFirstCall;}
	public void set_iShipId(int _iShipId) {this._iShipId = _iShipId;}
	public String get_sPreviousPort() {return _sPreviousPort;}
	public String get_sNextPort() {return _sNextPort;}
	public LocalDateTime get_dArrive() {return _dArrive;}
	public LocalDateTime get_dDeparture() {return _dDeparture;}
	
	public void set_iScaleId(int _iScaleId) {this._iScaleId = _iScaleId;}
	public void set_bFirstCall(boolean _bFirstCall) {this._bFirstCall = _bFirstCall;}
	public void set_sPreviousPort(String _sPreviousPort) {this._sPreviousPort = _sPreviousPort;}
	public void set_sNextPort(String _sNextPort) {this._sNextPort = _sNextPort;}
	public void set_dArrive(LocalDateTime _dArrive) {this._dArrive = _dArrive;}
	public void set_dDeparture(LocalDateTime _dDeparture) {this._dDeparture = _dDeparture;}
	

	
	

	
}
	
