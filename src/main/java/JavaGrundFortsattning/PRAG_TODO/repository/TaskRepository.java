package JavaGrundFortsattning.PRAG_TODO.repository;

import JavaGrundFortsattning.PRAG_TODO.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
