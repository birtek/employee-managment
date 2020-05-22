package pl.szydlowski.springbootcrudapi.service;

import pl.szydlowski.springbootcrudapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee getEmpoloyee(int id);
    void save(Employee employee);
    void delete(int id);
}
