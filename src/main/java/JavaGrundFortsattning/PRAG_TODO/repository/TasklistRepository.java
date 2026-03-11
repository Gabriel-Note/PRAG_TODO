package JavaGrundFortsattning.PRAG_TODO.repository;

import JavaGrundFortsattning.PRAG_TODO.entity.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasklistRepository extends JpaRepository<TaskList, Integer> {
}
