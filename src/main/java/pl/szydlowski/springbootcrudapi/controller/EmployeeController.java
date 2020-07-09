package pl.szydlowski.springbootcrudapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.szydlowski.springbootcrudapi.controller.dto.EmployeeDto;
import pl.szydlowski.springbootcrudapi.controller.dto.EmployeeDtoMapper;
import pl.szydlowski.springbootcrudapi.model.Employee;
import pl.szydlowski.springbootcrudapi.service.EmployeeService;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getEmployees(@RequestParam(required = false) String page) {
        return EmployeeDtoMapper.mapToEmployeeDtos(employeeService.getEmployees(page));
    }

    @GetMapping("/employees/tasks")
    public List<Employee> getEmployeesWithTasks(@RequestParam(required = false) String page) {
        return employeeService.getEmployeesWithTasks(page);
    }

    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(EmployeeDtoMapper.mapToEmployee(employeeDto));
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "Employee has been deleted with id: " + id;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employeeObj){
        employeeService.editEmployee(employeeObj);
        return employeeObj;
    }
}
