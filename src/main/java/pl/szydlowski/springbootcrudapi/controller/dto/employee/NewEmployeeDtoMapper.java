package pl.szydlowski.springbootcrudapi.controller.dto.employee;

import pl.szydlowski.springbootcrudapi.model.Employee;

public class NewEmployeeDtoMapper {
    private NewEmployeeDtoMapper(){}

    public static Employee mapToEmployee(NewEmployeeDto employeeDto){
        return Employee.builder()
                .name(employeeDto.getName())
                .lastName(employeeDto.getLastName())
                .department(employeeDto.getDepartment())
                .gender(employeeDto.getGender())
                .date(employeeDto.getDate())
                .phoneNumber(employeeDto.getPhoneNumber())
                .build();
    }
}
