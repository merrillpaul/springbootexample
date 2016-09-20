package hello.dao.secondary

import hello.domain.secondary.Emp
import org.springframework.data.jpa.repository.JpaRepository


public interface EmpRepository extends JpaRepository<Emp, Integer> {

}