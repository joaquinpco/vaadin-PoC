package Models;


public class User 
{
	private String _sNombre, _sApellido, _sPassword;
	private int _iCodigo;
	
	public User() {}
	
	/**
	 * 
	 * @param sNombre Nombre
	 * @param sApellido Apellido
	 * @param iCodigo Código
	 */
	public User(String sNombre, String sApellido, String sPassword, int iCodigo)
	{
		_sNombre = sNombre;
		_sApellido = sApellido;
		_iCodigo = iCodigo;
		_sPassword = sPassword;
	}
	
	//Getters y Setters
	public String getNombre() { return _sNombre; }
	public String getApellido() { return _sApellido; }
	public String getPassword() { return _sPassword; }
	public int iCodigo() { return _iCodigo; }
	
	public void setNombre(String sNombre) { _sNombre = sNombre; }
	public void setApellido(String sApellido) { _sApellido = sApellido; }
	public void setCodigo(int iCodigo) { _iCodigo = iCodigo; }
	public void setPassword(String sPassword) { _sPassword = sPassword; }
	
	@Override
	public String toString() { return "" + iCodigo(); }
}