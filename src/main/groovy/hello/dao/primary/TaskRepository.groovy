package hello.dao.primary

import hello.domain.primary.Task
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by upaulm2 on 8/25/16.
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {

}