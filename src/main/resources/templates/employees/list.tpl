import hello.dto.Employee

layout 'layout.tpl', title: 'Employees : View all',
		content: contents {
			div(class: 'container') {
				div(class: 'pull-right') {
					a(href: '?form', 'Create Employee')
				}
				table(class: 'table table-bordered table-striped') {
					thead {
						tr {
							td 'Ser'
							td 'ID'
							td 'Name'
							td 'Department'
						}
					}
					tbody {
						if (employees.empty) {
							tr { td(colspan: '3', 'No Employees') }
						}
						for (def employee: employees) {
							tr {
								td employee.id
								td employee.id
								td employee.name
								td {
									a(href:"/employees/${employee.id}") {
										yield employee.department
									}
								}
							}
						}

					}
				}




			}
		}