package com.mb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mb.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	
	@Query("from Employee")
	public List<Employee> getAllEmpRecords();
	
	@Query("from Employee where empId = :id")
	public Employee getEmpById(Integer id);
	
//	HQL query
//	select * from employee where emp_dept = :dept
	public List<Employee> findByEmpDept(String dept);
	
//	select * from employee where emp_gender = :gender
	public List<Employee> findByEmpGender(String gender);
	
//	select * from Employee where emp_gender =:gender and emp_dept =:dept;
	public List<Employee> findByEmpGenderAndEmpDept(String gender, String dept);

//	select * from employee where emp_salary >= 15000;
	public List<Employee> findByEmpSalaryGreaterThanEqual(Double salary);
	
//	Custom query
	@Query(value="select * from employee", nativeQuery = true)
	public List<Employee> getAllEmpsRecords();
	
	@Transactional
	@Modifying
	@Query("delete from Employee where empId=:eid")
	public void deleteEmp(Integer eid); 
	
}
