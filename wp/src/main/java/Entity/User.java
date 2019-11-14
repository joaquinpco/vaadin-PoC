package Entity;


public class User 
{
	private String _sName, _sLastName, _sPassword;
	private int _iAccessCode;
	
	public User() {}
	
	/**
	 * 
	 * @param sName Name
	 * @param sLastName LastName
	 * @param iAccessCode token Acces Code 
	 * @param sPassword Contrasenyeh
	 */
	public User(String sNombre, String sApellido, String sPassword, int iAccessCode)
	{
		_sName = sNombre;
		_sLastName = sApellido;
		_iAccessCode = iAccessCode;
		_sPassword = sPassword;
	}
	
	//Getters y Setters
	public String getName() { return _sName; }
	public String getLastName() { return _sLastName; }
	public String getPassword() { return _sPassword; }
	public int getAccessCode() { return _iAccessCode; }
	
	public void setName(String sNombre) { _sName = sNombre; }
	public void setLastName(String sLastName) { _sLastName = sLastName; }
	public void setAccessCode(int iAccessCode) { _iAccessCode = iAccessCode; }
	public void setPassword(String sPassword) { _sPassword = sPassword; }
	
	@Override
	public String toString() { return "" + getAccessCode(); }
}