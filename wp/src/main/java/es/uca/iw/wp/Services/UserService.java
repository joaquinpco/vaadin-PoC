package es.uca.iw.wp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.uca.iw.wp.Entity.User;
import es.uca.iw.wp.Repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository _oUsrRepository;
	
	private PasswordEncoder _oPwdEncoder;
	
	public UserService(PasswordEncoder oPwdEncoder, 
			UserRepository oUsrRepository)
	{
		super();
		_oPwdEncoder = oPwdEncoder;
		_oUsrRepository = oUsrRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String sName) 
			throws UsernameNotFoundException {
		
		User oUser = _oUsrRepository.findByName(sName);
		
		//Si no existe el usuario con ese nombre lo notificamos
		if(oUser == null)
			throw new UsernameNotFoundException(sName);
		
		return oUser;
	}
	
	public List<User> getUserList()
	{
		return _oUsrRepository.findAll();
	}

}
