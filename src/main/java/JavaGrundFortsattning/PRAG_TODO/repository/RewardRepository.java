package JavaGrundFortsattning.PRAG_TODO.repository;

import JavaGrundFortsattning.PRAG_TODO.entity.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Integer> {

    List<Reward> findByPointsNeededLessThanEqual(int totalPoints);
}
