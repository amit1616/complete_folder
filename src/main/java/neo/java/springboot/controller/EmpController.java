package neo.java.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import neo.java.springboot.entity.Employee;
import neo.java.springboot.service.EmpService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/")
public class EmpController {

	@Autowired
	private EmpService empService;

	// get all employee details
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return this.empService.getAllEmployees();

	}
	@PostMapping("/employees")
	public void saveToEmployee(@RequestBody Employee employee) {
		empService.saveToEmployee(employee);
	}

//	@PostMapping("/employees")
//	public Employee saveEmployee(@RequestBody Employee employee) {
//		return empservice.saveEmployee(employee);
//	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		return ResponseEntity.of(this.empService.getEmployeeById(id));

	}

	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee) {
		return ResponseEntity.ok(empService.updateEmployeeById(employee));

	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		this.empService.deleteEmployeeById(id);
		return "Employee is deleted successfully";
	}

}
