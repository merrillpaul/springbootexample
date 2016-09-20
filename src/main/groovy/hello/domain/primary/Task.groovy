package hello.domain.primary

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
class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	Integer id

	@Column(name = 'task_name')
	String taskName

	@Column(name = 'task_description')
	String taskDescription

	@Column(name = 'task_status')
	String taskStatus

	@Column(name = 'task_priority')
	String taskPriority

	@Column(name = 'task_archived')
	Integer taskArchived = 0

	@Override
	String toString() {
		"Task [ id = ${this.id}, taskName = ${this.taskName}, taskDescription = ${this.taskDescription}" +
				", taskStatus = ${this.taskStatus}, taskPriority = ${this.taskPriority}, taskArchived = ${this.taskArchived}]"
	}
}
