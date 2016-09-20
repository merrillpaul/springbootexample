package hello.controller

import hello.dto.Employee
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

/**
 * Created by upaulm2 on 8/19/16.
 */
@Controller
@RequestMapping("/employees")
class EmployeesController {
	@GetMapping
	public ModelAndView list() {
		def employees = [
				[
						id        : 'A100',
						name      : "Merrill",
						department: 'DPD'
				],
				[
						id        : 'A101',
						name      : "Shanya",
						department: 'Home'
				],
				[
						id        : 'A102',
						name      : "Ryan",
						department: '4th'
				],
				[
						id        : 'A103',
						name      : "Rachel",
						department: '1st'
				]
		]/*.collect { it ->
			new Employee(id: it.id, name: it.name, department: it.department)
		}*/
		return new ModelAndView("employees/list", "employees", employees)
	}
}
