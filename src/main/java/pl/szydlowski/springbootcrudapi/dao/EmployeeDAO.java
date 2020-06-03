package pl.szydlowski.springbootcrudapi.dao;

import pl.szydlowski.springbootcrudapi.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getEmployees();
    Employee getEmployeeById(int id);
    void save(Employee employee);
    void delete(int id);


}
