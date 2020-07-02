package pl.szydlowski.springbootcrudapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.szydlowski.springbootcrudapi.controller.dto.EmployeeDto;
import pl.szydlowski.springbootcrudapi.controller.dto.EmployeeDtoMapper;
import pl.szydlowski.springbootcrudapi.model.Employee;
import pl.szydlowski.springbootcrudapi.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getEmployees(@RequestParam(required = false) int page) {
        int pageNumber = page > 0 ? page : 1;
        return EmployeeDtoMapper.mapToEmployeeDtos(employeeService.getEmployees(pageNumber-1));
    }

    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employeeObj) {
        employeeService.saveEmployee(employeeObj);
        return employeeObj;
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
