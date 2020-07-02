package pl.szydlowski.springbootcrudapi.controller.dto;

import pl.szydlowski.springbootcrudapi.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDtoMapper {
    private EmployeeDtoMapper(){}

    public static List<EmployeeDto> mapToEmployeeDtos(List<Employee> employees) {
        return employees.stream()
                .map(employee -> mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .lastName(employee.getLastName())
                .department(employee.getDepartment())
                .gender(employee.getGender())
                .date(employee.getDate())
                .phoneNumber(employee.getPhoneNumber())
                .build();
    }
}
