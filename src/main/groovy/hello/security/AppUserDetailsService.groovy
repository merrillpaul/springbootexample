package hello.security

import org.springframework.context.annotation.Primary
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * Created by upaulm2 on 9/8/16.
 */
@Service
@Primary
class AppUserDetailsService implements UserDetailsService {

	@Override
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null
	}
}
