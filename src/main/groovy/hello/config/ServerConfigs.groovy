package hello.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * Created by upaulm2 on 8/18/16.
 */
@Component
@ConfigurationProperties(prefix = 'config')
class ServerConfigs {

	private List<String> servers = new ArrayList<String>();

	public List<String> getServers() {
		return this.servers;
	}

}
