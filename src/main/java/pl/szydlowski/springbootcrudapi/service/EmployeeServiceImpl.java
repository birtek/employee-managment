package pl.szydlowski.springbootcrudapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.szydlowski.springbootcrudapi.model.Employee;
import pl.szydlowski.springbootcrudapi.model.Task;
import pl.szydlowski.springbootcrudapi.repository.EmployeeRepository;
import pl.szydlowski.springbootcrudapi.repository.TaskRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int PAGE_SIZE =    5;
    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, TaskRepository taskRepository) {
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Employee> getEmployees(int page) {
    return employeeRepository.findAllEmployees(PageRequest
                .of(ServiceUtils.checkCorrectPage(page) - 1, PAGE_SIZE));
}

    @Override
    public List<Employee> getEmployeesWithTasks(int page) {
        List<Employee> employeeList = employeeRepository.findAllEmployees(PageRequest
                .of(ServiceUtils.checkCorrectPage(page) - 1, PAGE_SIZE));

        Set<Set<Integer>> ids2 = getTasksListIdFromEachEmployee(employeeList);
        Set<Integer> allId = getAllTaskID(ids2);

        List<Task> tasks = taskRepository.findAllByIdIn(allId);
        employeeList.forEach(employee -> employee.setTasks(extractTask(tasks,employee.getId())));
        return employeeList;
    }

    private Set<Integer> getAllTaskID(Set<Set<Integer>> ids2) {
        return ids2.stream()
                    .flatMap(Collection::stream)
                    .collect(Collectors.toSet());
    }

    private Set<Set<Integer>> getTasksListIdFromEachEmployee(List<Employee> employeeList) {
        return employeeList.stream()
                    .map(Employee::getTasksId)
                    .collect(Collectors.toSet());
    }

    private Set<Task> extractTask(List<Task> tasks, int id) {
        return tasks.stream()
                .filter(task -> task.getEmployeeId().contains(id))
                .collect(Collectors.toSet());
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id: " + id + " not found"));
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
                .orElseThrow(() -> new IllegalArgumentException("Employee with id: " + employee.getId() + " not found"));

        editedEmployee.setPhoneNumber(employee.getPhoneNumber());
        editedEmployee.setName(employee.getName());
        editedEmployee.setLastName(employee.getLastName());
        editedEmployee.setGender(employee.getGender());
        editedEmployee.setGender(employee.getGender());

        return editedEmployee;
    }

}
