package pl.szydlowski.springbootcrudapi.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.szydlowski.springbootcrudapi.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
        // return currentSession.createQuery("SELECT e FROM Employee e", Employee.class).list();
        TypedQuery<Employee> query = getSession().createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();

    }

    @Override
    public Employee getEmployeeById(int id) {
        return getSession().get(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        getSession().saveOrUpdate(employee);
    }

    @Override
    public void delete(int id) {
        Employee employee = getSession().get(Employee.class, id);
        getSession().delete(employee);

    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
