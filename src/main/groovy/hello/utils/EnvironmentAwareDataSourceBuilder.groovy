package hello.utils

import hello.utils.db.DBHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.context.ApplicationContext
import org.springframework.core.env.Environment
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup
import org.springframework.stereotype.Component

import javax.sql.DataSource
import java.sql.Connection

@Component
class EnvironmentAwareDataSourceBuilder {

	@Autowired
	Environment environment

	@Autowired
	ApplicationContext applicationContext


	def DataSource prepareDataSource(def properties) {
		DataSource dataSource = null
		if (properties['jndiName']) {
			dataSource = new JndiDataSourceLookup().getDataSource(properties['jndiName'])
		} else {
			dataSource = DataSourceBuilder.create().build()
			DataBinderUtils.populateObjectFromProperties(dataSource, properties)
		}

		if (environment.activeProfiles.contains('dev')) {
			Connection connection
			try {
				connection = dataSource.connection
				DBHelper helper = applicationContext.getBean("${connection.metaData.databaseProductName.toLowerCase()}Helper")
				helper.cleanup(connection)
			} catch (e) {
				e.printStackTrace()
			} finally {
				if (connection) {
					try {
						connection.close()
					} catch (e) {
						e.printStackTrace()
					}
				}
			}
		}

		dataSource
	}
}
