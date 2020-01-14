package es.uca.iw.wp.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;


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
	private String _sRole;
	
	@ManyToMany(mappedBy="_lstUser")
	private List<Ship> _lstShip;
	
	@OneToMany(mappedBy="_oUser")
	private List<Invoice> _lstInvoice;
	
	@OneToMany(mappedBy="_oUser", fetch=FetchType.LAZY)
	private List<Book> _lstBook;
	
	public User() {}
	
	/**
	 * 
	 * @param sName Name
	 * @param sLastName LastName
	 * @param iAccessCode token Acces Code 
	 * @param sPassword Contrasenyeh
	 * @param sRole User role
	 */
	public User(String sNombre, String sApellido, String sPassword, String  sRole, int iAccessCode)
	{
		_sName = sNombre;
		_sLastName = sApellido;
		_iAccessCode = iAccessCode;
		_sPassword = sPassword;
		_sRole = sRole;
	}
	
	//Getters y Setters
	public String getName() { return _sName; }
	public String getLastName() { return _sLastName; }
	public String getPassword() { return _sPassword; }
	public int getAccessCode() { return _iAccessCode; }
	public String getRole() { return _sRole; }
	
	public void setName(String sNombre) { _sName = sNombre; }
	public void setLastName(String sLastName) { _sLastName = sLastName; }
	public void setAccessCode(int iAccessCode) { _iAccessCode = iAccessCode; }
	public void setPassword(String sPassword) 
	{
		_sPassword = sPassword; 
	}
	
	public void setRole(String sRole) { _sRole = sRole; }
	
	public void addUser(Book oBook)
	{	
		_lstBook.add(oBook);
	}
	
	@Override
	public String toString() { return "" + getName() + " " + getLastName(); }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> oLstPermission = 
				new ArrayList<GrantedAuthority>();
		
		Collections.addAll(oLstPermission, new SimpleGrantedAuthority("admin"), 
				new SimpleGrantedAuthority("manager"), new SimpleGrantedAuthority("user"));
		
		return oLstPermission;
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