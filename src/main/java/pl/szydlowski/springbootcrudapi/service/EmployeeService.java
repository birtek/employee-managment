package pl.szydlowski.springbootcrudapi.service;

import pl.szydlowski.springbootcrudapi.model.Employee;


import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(String page);
    Employee getEmployeeById(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(int id);
    Employee editEmployee(Employee employee);
    List<Employee> getEmployeesWithTasks(String page);

}
