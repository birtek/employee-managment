package pl.szydlowski.springbootcrudapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.szydlowski.springbootcrudapi.dao.EmployeeDAO;
import pl.szydlowski.springbootcrudapi.model.Employee;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    @Override
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    @Transactional
    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = employeeDAO.getEmployeeById(id);
        if(employee == null){
            throw new RuntimeException("Employee with id: "+ id + " not found");
        }
        return employee;
    }

    @Transactional
    @Override
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }
}
