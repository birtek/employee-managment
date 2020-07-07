package pl.szydlowski.springbootcrudapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.szydlowski.springbootcrudapi.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select distinct e from Employee e ")
    List<Employee> findAllEmployees(Pageable page);

    @Query("select distinct e from Employee e left join fetch e.tasks")
    List<Employee> findAllEmployeesWithPost(Pageable page);

    @Override
    @Query("select distinct e from Employee e left join fetch e.tasks where e.id = :id ")
    Optional<Employee> findById(@Param("id") Integer integer);


}
