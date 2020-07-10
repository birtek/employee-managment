package pl.szydlowski.springbootcrudapi.controller.dto.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.szydlowski.springbootcrudapi.model.Gender;

import java.time.LocalDate;

public class NewEmployeeDto {

        private String name;
        private String lastName;
        private Gender gender;
        private String department;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDate date;
        private String phoneNumber;

        private NewEmployeeDto(){};

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

            public NewEmployeeDto build(){
                NewEmployeeDto newEmployee = new NewEmployeeDto();

                newEmployee .name = this.name;
                newEmployee .lastName = this.lastName;
                newEmployee .department = this.department;
                newEmployee .gender = this.gender;
                newEmployee .date = this.date;
                newEmployee .phoneNumber = this.phoneNumber;

                return newEmployee;
            }
        }
        public static Builder builder(){
            return new Builder();
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
