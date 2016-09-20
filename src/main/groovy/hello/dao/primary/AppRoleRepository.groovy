package hello.dao.primary

import hello.domain.primary.AppRole
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by upaulm2 on 9/13/16.
 */
public interface AppRoleRepository extends JpaRepository<AppRole, String> {
	AppRole findByAuthority(String authority)
}