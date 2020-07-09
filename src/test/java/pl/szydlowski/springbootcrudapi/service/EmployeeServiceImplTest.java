package pl.szydlowski.springbootcrudapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.szydlowski.springbootcrudapi.model.Employee;
import pl.szydlowski.springbootcrudapi.model.Gender;
import pl.szydlowski.springbootcrudapi.repository.EmployeeRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getEmployeeById() {

        Employee employee = Employee.builder()
                .id(1)
                .name("Alex")
                .lastName("Stecko")
                .department("hr")
                .gender(Gender.MALE)
                .date(LocalDate.parse("1994-12-13"))
                .phoneNumber("987654321")
                .build();



        when(employeeService.getEmployeeById(anyInt())).thenReturn(employee);

        Employee employeeFound = employeeService.getEmployeeById(2);

        assertNotNull(employeeFound);

        assertEquals("Alexy",employeeFound.getName());
        assertEquals(2,employeeFound.getId());
    }
}