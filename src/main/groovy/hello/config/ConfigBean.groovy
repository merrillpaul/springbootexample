package hello.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
class ConfigBean {

	@Value('${config.appName}')
	String name

	@Value('${config.description}')
	String description


}
