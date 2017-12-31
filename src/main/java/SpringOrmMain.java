import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.spring.sample.springorm.config.AppConfig;
import com.spring.sample.springorm.model.Employee;
import com.spring.sample.springorm.service.EmployeeService;


public class SpringOrmMain {

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeService service = (EmployeeService) context.getBean("employeeService");

		//Create employee
		Employee employee1 = new Employee();

		employee1.setEmpId("S02");
		employee1.setName("Vishnu Ravi");
		employee1.setDepartment("IT");
		employee1.setCity("Kochi");

		service.create(employee1);
		System.out.println("Employee inserted");

		System.out.println(service.findAll());

		//Update employee details
		Employee employee = service.findById("S02");
		employee.setDepartment("CS");
		service.update(employee);
		System.out.println("Employee details updated"+service.findById("S02"));

		//Delete an employee
		service.delete("S02");
		System.out.println("Employee deleted");

		//List all employees
		System.out.println("Final EmployeeList : "+service.findAll());

	}
}
