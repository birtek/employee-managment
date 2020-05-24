package pl.szydlowski.springbootcrudapi.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.szydlowski.springbootcrudapi.model.Employee;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getEmployees() {
        Session currentSession = getSession();
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
        return query.getResultList();

    }

    @Override
    public Employee getEmpoloyee(int id) {
        Session currentSession = getSession();
        // Query<Employee> query = currentSession.createQuery( Employee.class,id);
        //return query.getResultList();
        return null;
    }

    @Override
    public void save(Employee employee) {
        Session currentSession = getSession();
        currentSession.save(employee);
    }

    @Override
    public void delete(int id) {

    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
