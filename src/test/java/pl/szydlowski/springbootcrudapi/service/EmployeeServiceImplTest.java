package pl.szydlowski.springbootcrudapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.szydlowski.springbootcrudapi.dao.EmployeeDAO;
import pl.szydlowski.springbootcrudapi.model.Employee;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeDAO employeeDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getEmployeeById() {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setDate(LocalDate.parse("1994-12-13"));
        employee.setDepartment("hr");
        employee.setGender("male");
        employee.setName("Alex");

        when(employeeDAO.getEmployeeById(anyInt())).thenReturn(employee);

        Employee employeeFound = employeeService.getEmployeeById(22);

        assertNotNull(employeeFound);

        assertEquals("Alex",employeeFound.getName());
        assertEquals(1,employeeFound.getId());
    }
}