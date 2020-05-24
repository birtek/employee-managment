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

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employeeObj) {
        employeeService.save(employeeObj);
        return employeeObj;
    }
}
