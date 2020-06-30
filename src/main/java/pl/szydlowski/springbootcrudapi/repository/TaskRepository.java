package pl.szydlowski.springbootcrudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szydlowski.springbootcrudapi.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}
