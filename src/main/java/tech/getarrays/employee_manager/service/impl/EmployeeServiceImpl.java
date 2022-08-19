package tech.getarrays.employee_manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employee_manager.exception.UserNotFoundException;
import tech.getarrays.employee_manager.model.Employee;
import tech.getarrays.employee_manager.repo.EmployeeRepo;
import tech.getarrays.employee_manager.service.IEmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> getById(Long id) {
        return Optional.ofNullable(employeeRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found")));
    }

    @Override
    public Employee save(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepo.deleteById(id);
    }
}
