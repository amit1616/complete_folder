package neo.java.springboot.service;

import java.util.List;
import java.util.Optional;

import neo.java.springboot.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import neo.java.springboot.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmpService {


	@Autowired
	private EmpRepo empRepo;

	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = empRepo.findAll();
		return employeeList;
	}

	public void saveToEmployee( Employee employee) {
		empRepo.save(employee);
	}

	public Optional<Employee> getEmployeeById(Long id) {
		return empRepo.findById(id);
	}

	public Employee updateEmployeeById(Employee employee) {
		return empRepo.save(employee);
	}

	public void deleteEmployeeById(Long id) {
		 empRepo.deleteById(id);
	}
}
