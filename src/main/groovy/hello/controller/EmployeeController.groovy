package hello.controller

import hello.config.ConfigBean
import hello.config.ServerConfigs
import hello.dao.primary.AppUserRepository
import hello.dao.primary.TaskRepository
import hello.dao.secondary.EmpRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import groovy.json.*

@RestController
@RequestMapping("/rest")
public class EmployeeController {

	@Autowired
	private ConfigBean configBean

	@Autowired
	private ServerConfigs configuration

	@Autowired
	TaskRepository taskRepository

	@Autowired
	EmpRepository empRepository

	@Autowired
	AppUserRepository appUserRepository

	@RequestMapping(value = "/emps", produces = MediaType.APPLICATION_JSON_VALUE)
	public String index() {

		println "########## Config ${configBean.name} ###########"

		println "########## App Description ${configBean.description} ###########"

		println "########## Servers ${configuration.servers} ###########"

		JsonOutput.toJson(empRepository.findAll())
	}

	@RequestMapping("/servers")
	public String servers() {
		JsonOutput.toJson(configuration.servers.collect { " SERVER = (${it})" })
	}


	@RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
	public String tasks() {
		JsonOutput.toJson(taskRepository.findAll())
	}

	@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public String users() {
		JsonOutput.toJson(appUserRepository.findAll())
	}
}

