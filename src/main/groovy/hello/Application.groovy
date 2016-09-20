package hello

import hello.utils.EnvironmentAwareDataSourceBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.transaction.PlatformTransactionManager

import javax.sql.DataSource

/**
 * Created by upaulm2 on 8/18/16.
 */
@SpringBootApplication
class Application extends SpringBootServletInitializer  {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class)
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(Application.class, args)
		println("Let's inspect the beans provided by Spring Boot:")
		def beanNames = ctx.getBeanDefinitionNames().sort()
		beanNames.each { println it }
		ctx.start()
	}

	@Autowired
	EnvironmentAwareDataSourceBuilder environmentAwareDataSourceBuilder

	@Bean(name = "primaryDSConfig")
	@Primary
	@ConfigurationProperties(prefix = "primaryDatasource")
	public def preparePrimaryDataSourceConfigs() {
		[:]
	}

	@Bean(name = "secondaryDSConfig")
	@ConfigurationProperties(prefix = "secondaryDatasource")
	public def prepareSecondaryDataSourceConfigs() {
		[:]
	}

	@Bean
	@Primary
	public DataSource primaryDataSource() {
		println "@@@@@@@@@@@Preparing Primary Datasource"
		environmentAwareDataSourceBuilder.prepareDataSource(preparePrimaryDataSourceConfigs())
	}

	@Bean
	public DataSource secondaryDataSource() {
		println "@@@@@@@@@@@@@ Preparing Secondary  Datasource"
		environmentAwareDataSourceBuilder.prepareDataSource(prepareSecondaryDataSourceConfigs())
	}

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		builder
				.dataSource(primaryDataSource())
				.packages('hello.domain.primary')
				.persistenceUnit("primary")
				.build()
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		builder
				.dataSource(secondaryDataSource())
				.packages('hello.domain.secondary') // comma separated with var args
				.persistenceUnit("secondary")
				.build()
	}


	@Primary
	@Bean
	public PlatformTransactionManager primaryTransactionManager() {
		def transactionManager = new JpaTransactionManager()
		transactionManager.setEntityManagerFactory(primaryEntityManagerFactory().getObject())
		transactionManager
	}

	@Bean
	public PlatformTransactionManager secondaryTransactionManager() {
		def transactionManager = new JpaTransactionManager()
		transactionManager.setEntityManagerFactory(secondaryEntityManagerFactory().getObject())
		transactionManager
	}


	@Bean
	@Primary
	public PasswordEncoder passwordEncoder() {
		new BCryptPasswordEncoder()
	}
}
