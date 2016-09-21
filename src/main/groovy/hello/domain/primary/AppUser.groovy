package hello.domain.primary

import hello.domain.AbstractEntity
import hello.jpa.AppUserEntityListener
import org.hibernate.annotations.GenericGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.OneToMany
import javax.persistence.PrePersist
import javax.persistence.Table
import javax.persistence.Transient
import javax.persistence.Version
import java.sql.Timestamp


/**
 * Created by upaulm2 on 9/8/16.
 */
@Entity
@EntityListeners(AppUserEntityListener.class)
class AppUser extends AbstractEntity {

	@Column(nullable = false, unique = true)
	String username

	@Column(nullable = false)
	String password

	@Column(nullable = false)
	String firstName

	@Column(nullable = false)
	String lastName

	@Column(nullable = false)
	String honorific

	String timeZoneId

	String modifiedBy

	boolean enabled

	boolean accountExpired

	boolean accountLocked

	Timestamp lastUnlocked

	Integer failedLogins

	boolean confirmed

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable
			(
					name = "appUserRoles",
					joinColumns = [@JoinColumn(name = "userId", referencedColumnName = "id")],
					inverseJoinColumns = [@JoinColumn(name = "roleId", referencedColumnName = "id")]
			)
	List<AppRole> roles

}
