package hello.listeners

import hello.dao.primary.AppRoleRepository
import hello.dao.primary.AppUserRepository
import hello.domain.primary.AppRole
import hello.domain.primary.AppUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent
import org.springframework.boot.context.event.ApplicationPreparedEvent
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.ContextStartedEvent
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import java.sql.Timestamp
import java.time.LocalDateTime

/**
 * Created by upaulm2 on 9/8/16.
 */
@Component
class ApplicationStartedListener implements ApplicationListener<ContextStartedEvent> {

	@Autowired
	Environment environment

	@Autowired
	AppRoleRepository appRoleRepository

	@Autowired
	AppUserRepository appUserRepository

	@Override
	void onApplicationEvent(ContextStartedEvent event) {
		println "@@@@Starting Up Our APP with profile : ${environment.getActiveProfiles().join(',')} "

		if (environment.getActiveProfiles().contains('dev')) {
			insertDevData()
		}
	}


	def insertDevData () {

		// adding roles
		[
				"ROLE_SYSTEM_ADMIN",
				"ROLE_CLINICIAN",
				"ROLE_CUSTOMER_SERVICE",
				"ROLE_FINANCE",
				"ROLE_NO_ROLES"
		].each {
			appRoleRepository.save(new AppRole(authority: it, dateCreated: Timestamp.valueOf(LocalDateTime.now())))
		}

		def user = appUserRepository.save(new AppUser(username: 'merrill', password: 'Password1!', firstName: "Merrill",
				lastName: 'Paul', timeZoneId: TimeZone.default.ID, honorific: 'Mr',
				accountExpired: false, accountLocked: false, dateCreated: Timestamp.valueOf(LocalDateTime.now()),
				enabled: true))

		def roles = [
		        "ROLE_SYSTEM_ADMIN",
				"ROLE_CLINICIAN"
		].collect {
			 appRoleRepository.findByAuthority(it)
		}
		user.roles = roles
		appUserRepository.save(user)

	}
}
