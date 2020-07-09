package pl.szydlowski.springbootcrudapi.model;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "tbl_employee")
public class Employee {
    private Employee(){}
    //UUID uuid = UUID.randomUUID();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer id;

    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String department;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "dob")
    private LocalDate date;
    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbl_employee_task",
            joinColumns = {@JoinColumn(name = "id_employee")},
            inverseJoinColumns = {@JoinColumn(name = "id_task")}
    )
    @JsonIgnoreProperties("employees")
    private Set<Task> tasks;

    public void addTask(Task task){
        this.tasks.add(task);
        task.getEmployees().add(this);
    }

    public void removeTask(Task task){
        this.tasks.remove(task);
        task.getEmployees().remove(this);
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", department='" + department + '\'' +
                ", date=" + date +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
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

        public Employee build(){
            Employee employeeDto = new Employee();

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
}
