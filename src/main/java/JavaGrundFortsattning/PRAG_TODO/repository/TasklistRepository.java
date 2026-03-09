package JavaGrundFortsattning.PRAG_TODO.repository;

import JavaGrundFortsattning.PRAG_TODO.entity.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasklistRepository extends JpaRepository<TaskList, Integer> {
}
