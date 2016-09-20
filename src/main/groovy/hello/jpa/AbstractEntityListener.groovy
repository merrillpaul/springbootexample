package hello.jpa

import hello.domain.AbstractEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

import javax.persistence.PrePersist
import javax.persistence.PreUpdate
import java.sql.Timestamp
import java.time.LocalDateTime

/**
 * Created by upaulm2 on 9/13/16.
 */
@Component
class AbstractEntityListener {

	@PreUpdate
	public void onBeforeUpdate(AbstractEntity abstractEntity) {
		def now = Timestamp.valueOf(LocalDateTime.now())
		abstractEntity.lastUpdated = now
	}


	@PrePersist
	public void onBeforeInsert(AbstractEntity abstractEntity) {
		def now = Timestamp.valueOf(LocalDateTime.now())
		abstractEntity.dateCreated = now
		abstractEntity.lastUpdated = now
	}
}
