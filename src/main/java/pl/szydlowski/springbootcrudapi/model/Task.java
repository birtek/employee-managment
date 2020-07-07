package pl.szydlowski.springbootcrudapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "tbl_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task")
    private Integer id;

    private String description;

    @Column(name = "begin")
    private LocalDate taskBegin;

    @Column(name = "end")
    private LocalDate taskEnd;

    private Boolean status;

    @ManyToMany(mappedBy = "tasks")
    @JsonIgnoreProperties("tasks")
    private Set<Employee> employees;

    public Set<Employee> getEmployees() {
      return employees;
}
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTaskBegin() {
        return taskBegin;
    }

    public void setTaskBegin(LocalDate taskBegin) {
        this.taskBegin = taskBegin;
    }

    public LocalDate getTaskEnd() {
        return taskEnd;
    }

    public void setTaskEnd(LocalDate taskEnd) {
        this.taskEnd = taskEnd;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", taskBegin=" + taskBegin +
                ", taskEnd=" + taskEnd +
                ", status=" + status +
                ", employees=" + employees +
                '}';
    }
}
