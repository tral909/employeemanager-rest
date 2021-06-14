package io.github.tral909.employeemanager.service;

import io.github.tral909.employeemanager.exception.UserNotFoundException;
import io.github.tral909.employeemanager.model.Employee;
import io.github.tral909.employeemanager.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	//todo добавить обработчик ексепшина, чтобы 404 возвращалось с текстом
	public Employee findEmployee(Long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
	}

	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}

	public Employee addEmployee(Employee employee) {
		employee.setCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

}
