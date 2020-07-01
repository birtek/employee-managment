package pl.szydlowski.springbootcrudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.szydlowski.springbootcrudapi.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Override
    @Query("select distinct e from Employee e join fetch e.tasks")
    List<Employee> findAll();
}
