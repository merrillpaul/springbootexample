package hello.config.jpa

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

/**
 * Created by upaulm2 on 8/25/16.
 */
@Configuration
@EnableJpaRepositories(
		basePackages = 'hello.dao.secondary',
		entityManagerFactoryRef = 'secondaryEntityManagerFactory',
		transactionManagerRef = 'secondaryTransactionManager'
)
class SecondaryConfig {
}
