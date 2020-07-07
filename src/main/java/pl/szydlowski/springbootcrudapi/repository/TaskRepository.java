package pl.szydlowski.springbootcrudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.szydlowski.springbootcrudapi.model.Task;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    @Override
    @Query("Select t from Task t left join fetch t.employees")
    List<Task> findAll();

    @Override
    @Query("Select t from Task t left join fetch t.employees where t.id = :id")
    Optional<Task> findById(@Param("id")Integer integer);


    List<Task> findAllByIdIn(Set<Integer> ids);

}
