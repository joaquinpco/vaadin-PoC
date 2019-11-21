package es.uca.iw.wp.Entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class User implements UserDetails
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5740932781665768714L;
	
	@Id
	@GeneratedValue
	private Long id;
	
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return _sName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}