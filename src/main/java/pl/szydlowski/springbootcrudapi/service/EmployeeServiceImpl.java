package pl.szydlowski.springbootcrudapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.szydlowski.springbootcrudapi.model.Employee;
import pl.szydlowski.springbootcrudapi.repository.EmployeeRepository;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElseThrow(IllegalStateException::new);
    }

    @Transactional
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Employee editEmployee(Employee employee) {
        Employee editedEmployee = employeeRepository.findById(employee.getId()).orElseThrow(IllegalStateException::new);

        editedEmployee.setPhoneNumber(employee.getPhoneNumber());
        editedEmployee.setName(employee.getName());
        editedEmployee.setLastName(employee.getLastName());
        editedEmployee.setGender(employee.getGender());
        editedEmployee.setGender(employee.getGender());

        return editedEmployee;
    }
}
