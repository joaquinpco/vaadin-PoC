package Services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

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
		
		return null;
	}

}
