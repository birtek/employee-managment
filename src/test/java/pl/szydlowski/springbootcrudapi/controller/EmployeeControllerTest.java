package pl.szydlowski.springbootcrudapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.szydlowski.springbootcrudapi.model.Employee;
import pl.szydlowski.springbootcrudapi.service.EmployeeServiceImpl;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class EmployeeControllerTest {

    @InjectMocks
    EmployeeController employeeController;

    @Mock
    EmployeeServiceImpl employeeService;

    Employee employee;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        employee = new Employee();
        employee.setId(1);
        employee.setDate(LocalDate.parse("1994-12-13"));
        employee.setDepartment("hr");
        employee.setGender("male");
        employee.setName("Alex");
    }

    @Test
    void getEmployee() {
        when(employeeService.getEmployeeById(anyInt())).thenReturn(employee);

        Employee employeeRest = employeeController.getEmployee(97);

        assertNotNull(employeeRest);
        assertEquals(employee.getName(),employeeRest.getName());
    }
}