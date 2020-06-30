package pl.szydlowski.springbootcrudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.szydlowski.springbootcrudapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
