package hello.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User

/**
 * This class is used to hold an authentication "principal" (a loggedin user) objects of this type are never persisted,
 * but are only used at runtime to hold the information about a user
 */
class AppUserDetails extends User {

	def id
	static final List NO_ROLES = [new SimpleGrantedAuthority(SecurityUtils.NO_ROLE)]
	def firstName
	def lastName
	def honorific

	boolean passwordOverAgeRequirement
	boolean passwordChangedByAdmin
	List<String> policyIdsToAccept = null

	AppUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
				boolean credentialsNonExpired, boolean accountNonLocked,
				Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities)
		this.id = id

	}

}
