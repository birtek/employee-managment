package pl.szydlowski.springbootcrudapi.controller.dto;

import pl.szydlowski.springbootcrudapi.model.Gender;

import java.time.LocalDate;

public class EmployeeDto {
    private Integer id;
    private String name;
    private String lastName;
    private Gender gender;
    private String department;
    private LocalDate date;
    private String phoneNumber;

    private EmployeeDto(){};

    public static final class Builder {
        private Integer id;
        private String name;
        private String lastName;
        private Gender gender;
        private String department;
        private LocalDate date;
        private String phoneNumber;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public EmployeeDto build(){
            EmployeeDto employeeDto = new EmployeeDto();

            employeeDto.id = this.id;
            employeeDto.name = this.name;
            employeeDto.lastName = this.lastName;
            employeeDto.department = this.department;
            employeeDto.gender = this.gender;
            employeeDto.date = this.date;
            employeeDto.phoneNumber = this.phoneNumber;

            return employeeDto;
        }
    }
    public static Builder builder(){
        return new Builder();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
