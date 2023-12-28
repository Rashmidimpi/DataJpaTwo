package com.mb;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mb.entity.Employee;
import com.mb.repo.EmployeeRepo;
import com.mb.service.EmployeeService;

@SpringBootApplication
public class DataJpaCrudRepoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context
		= SpringApplication.run(DataJpaCrudRepoApplication.class, args);
		EmployeeService service = context.getBean(EmployeeService.class);
//		service.saveEmployee();
//		service.saveMultipleEmployees();
//		service.getEmp();
//		service.getMultipleEmp();
//		service.grtAllEmps();
//		service.getEmpsByDept("dev");
//		service.getEmpsByGender("Female");
//		service.getEmpsByGenderAndDept("Male", "Dev");
//		service.getEmpsBySalary(20000.00);
//		service.getAllEmpRecords();
//		service.getEmpById(101);
		
//		EmployeeRepo empRepo = context.getBean(EmployeeRepo.class);
//		List<Employee> allEmp = empRepo.getAllEmpRecords();
//		List<Employee> allEmp = empRepo.getAllEmpsRecords();
//		allEmp.forEach(System.out::println);
//		empRepo.deleteEmp(103);
		
		service.getEmployees();
		
		
		
	}

}
