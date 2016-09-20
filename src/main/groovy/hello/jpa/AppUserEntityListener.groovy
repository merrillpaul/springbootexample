package hello.jpa

import hello.domain.AbstractEntity
import hello.domain.primary.AppUser
import hello.utils.AutoWireHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

import javax.persistence.PrePersist
import java.sql.Timestamp
import java.time.LocalDateTime

/**
 * Created by upaulm2 on 9/13/16.
 */
@Component
class AppUserEntityListener {


	@PrePersist
	public void onBeforeInsert(AppUser userEntity) {
		PasswordEncoder passwordEncoder = AutoWireHelper.getBean(PasswordEncoder.class)
		println "Before insert password encoder ${passwordEncoder}"
		if(userEntity.password) {
			userEntity.password = passwordEncoder.encode(userEntity.password)
		}
	}
}
