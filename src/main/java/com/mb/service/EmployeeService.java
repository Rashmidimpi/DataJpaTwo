package com.mb.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mb.entity.Employee;
import com.mb.repo.EmployeeRepo;

@Service
public class EmployeeService {
	private EmployeeRepo empRepo;
	public EmployeeService(EmployeeRepo empRepo) {
		this.empRepo = empRepo;
		System.out.println(this.empRepo.getClass().getName());
		
	}
	
	public void saveEmployee() {
		Employee emp = new Employee();
		emp.setEmpId(101);
		emp.setEmpName("Murat");
		emp.setEmpGender("Male");
		emp.setEmpDept("Dev");
		emp.setEmpSalary(15000.00);
		empRepo.save(emp);
	}
	
	public void saveMultipleEmployees() {
		Employee emp1 = new Employee();
		emp1.setEmpId(102);
		emp1.setEmpName("Hayat");
		emp1.setEmpGender("Female");
		emp1.setEmpDept("Dev");
		emp1.setEmpSalary(19000.00);
		
		Employee emp2 = new Employee();
		emp2.setEmpId(103);
		emp2.setEmpName("Ipek");
		emp2.setEmpGender("Female");
		emp2.setEmpDept("Dev");
		emp2.setEmpSalary(29000.00);
		
		List<Employee> empList = Arrays.asList(emp1,emp2);
		empRepo.saveAll(empList);
		
	}
	
	public void getEmp() {
		Optional<Employee> findById = empRepo.findById(101);
		if(findById.isPresent()) {
			Employee employee = findById.get();
			System.out.println(employee);
		}
	}
	
	public void getMultipleEmp() {
		List<Integer> empIds = Arrays.asList(102,103); 
				Iterable<Employee> itr = empRepo.findAllById(empIds);
				itr.forEach(System.out::println);
				
	}
	
	public void grtAllEmps() {
		Iterable<Employee> findAll = empRepo.findAll();
		findAll.forEach(System.out::println);
	}
	
	public void getEmpsByDept(String dept) {
		List<Employee> emps = empRepo.findByEmpDept(dept);
		emps.forEach(System.out::println);
	}
	
	public void getEmpsByGender(String gender) {
		List<Employee> emps = empRepo.findByEmpGender(gender);
		emps.forEach(System.out::println);
	}
	
	public void getEmpsByGenderAndDept(String gender, String dept) {
		List<Employee> emps = empRepo.findByEmpGenderAndEmpDept(gender, dept);
		emps.forEach(System.out::println);
	}
	
	public void getEmpsBySalary(Double salary) {
		List<Employee> emps = empRepo.findByEmpSalaryGreaterThanEqual(salary);
		emps.forEach(System.out::println);
		
	}
	
	public void getAllEmpRecords() {
		List<Employee> emps = empRepo.getAllEmpRecords();
		emps.forEach(System.out::println);
	}
	
	public void getEmpById(Integer id) {
		Employee emp = empRepo.getEmpById(id);
		System.out.println(emp);
	}
	
	public void getEmployees() {
		Iterable<Employee> findAll = empRepo.findAll();
		findAll.forEach(e -> System.out.println(e));
	}

}
