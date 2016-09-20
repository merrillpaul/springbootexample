package hello.dao.primary

import hello.domain.primary.AppUser
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by upaulm2 on 9/13/16.
 */
public interface AppUserRepository extends JpaRepository<AppUser, String>{

}