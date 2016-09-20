package hello.domain

import hello.jpa.AbstractEntityListener
import org.hibernate.annotations.GenericGenerator

import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import java.sql.Timestamp

/**
 * Created by upaulm2 on 9/13/16.
 */
@EntityListeners(AbstractEntityListener.class)
@MappedSuperclass
abstract class AbstractEntity {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(columnDefinition = "CHAR(32)")
	String id

	Timestamp dateCreated

	Timestamp lastUpdated

}
