package tech.getarrays.employee_manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.getarrays.employee_manager.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
