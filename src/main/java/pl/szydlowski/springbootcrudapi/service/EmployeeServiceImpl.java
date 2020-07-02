package pl.szydlowski.springbootcrudapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.szydlowski.springbootcrudapi.model.Employee;
import pl.szydlowski.springbootcrudapi.repository.EmployeeRepository;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int PAGE_SIZE = 5;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @Override
    public List<Employee> getEmployees(int page) {
        return employeeRepository.findAllEmployees(PageRequest.of(page,PAGE_SIZE));
    }

    @Transactional
    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Employee with id: "+id+" not found"));
    }

    @Transactional
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Employee editEmployee(Employee employee) {
        Employee editedEmployee = employeeRepository.findById(employee.getId())
                .orElseThrow(()->new IllegalArgumentException("Employee with id: "+employee.getId()+" not found"));

        editedEmployee.setPhoneNumber(employee.getPhoneNumber());
        editedEmployee.setName(employee.getName());
        editedEmployee.setLastName(employee.getLastName());
        editedEmployee.setGender(employee.getGender());
        editedEmployee.setGender(employee.getGender());

        return editedEmployee;
    }
}
