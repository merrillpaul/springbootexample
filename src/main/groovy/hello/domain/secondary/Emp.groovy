package hello.domain.secondary

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by upaulm2 on 8/25/16.
 */
@Entity
@Table(name = "emp")
class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Integer id

	@Column(name = 'name')
	String name

	@Override
	String toString() {
		"Emp [ id = ${this.id}, name = ${this.name}]"
	}
}
