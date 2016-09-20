package hello.domain.primary

import hello.domain.AbstractEntity
import org.hibernate.annotations.GenericGenerator

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.NamedQuery
import java.sql.Timestamp


@Entity
/*@NamedQuery(name = "AppRole.findByAuthority",
		query = "select ar from AppRole ar where ar.authority = ?1")*/
class AppRole extends AbstractEntity {

	@Column(nullable = false, unique = true)
	String authority

	public String toString() {
		authority
	}
}
