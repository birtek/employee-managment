package pl.szydlowski.springbootcrudapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.szydlowski.springbootcrudapi.model.Employee;
import pl.szydlowski.springbootcrudapi.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee == null){
            throw new RuntimeException("Employee with id: "+ id + " not found");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employeeObj) {
        employeeService.save(employeeObj);
        return employeeObj;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.delete(id);
        return "Employee has been deleted with id: " + id;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employeeObj){
        employeeService.save(employeeObj);
        return employeeObj;
    }
}
