package com.vti.mock.config.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vti.mock.repository.CandidateRepository;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private final CandidateRepository userRepository;

	public MyUserDetailsService(CandidateRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		Optional<com.vti.mock.domain.CandidateEntity> userOptional = userRepository.findByUsername(username);
		if (!userOptional.isPresent()) {
			throw new UsernameNotFoundException("Username Not Found");
		}
		boolean enabled = userOptional.get().isEnable();
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		return new User(username, userOptional.get().getPassword(), enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, userOptional.get().getAuthorities());
	}

}
