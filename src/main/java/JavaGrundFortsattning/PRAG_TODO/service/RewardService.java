package JavaGrundFortsattning.PRAG_TODO.service;

import JavaGrundFortsattning.PRAG_TODO.dto.RewardDto;
import JavaGrundFortsattning.PRAG_TODO.entity.Reward;
import JavaGrundFortsattning.PRAG_TODO.entity.Task;
import JavaGrundFortsattning.PRAG_TODO.repository.RewardRepository;
import JavaGrundFortsattning.PRAG_TODO.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RewardService {

    private final RewardRepository rewardRepository;
    private final TaskRepository taskRepository;

    public RewardService(RewardRepository rewardRepository, TaskRepository taskRepository) {
        this.rewardRepository = rewardRepository;
        this.taskRepository = taskRepository;
    }

    public List<RewardDto> getAllRewards() {
        List<Reward> allRewards = rewardRepository.findAll();
        List<RewardDto> rewardDtoList = new ArrayList<>();
        for (Reward reward : allRewards) {
            RewardDto rewardDto = new RewardDto();
            rewardDto.setId(reward.getId());
            rewardDto.setMessage(reward.getMessage());
            rewardDto.setPointsNeeded(reward.getPointsNeeded());
            rewardDtoList.add(rewardDto);
        }
        return rewardDtoList;
    }

    public Reward getRewardById(int id) {
        Optional<Reward> optionalReward = rewardRepository.findById(id);
        if (optionalReward.isPresent()) {
            return optionalReward.get();
        } else {
            throw new RuntimeException("Reward not found with id: " + id);
        }
    }

    public Reward createReward(RewardDto rewardDto) {
        Reward reward = new Reward();
        reward.setMessage(rewardDto.getMessage());
        reward.setPointsNeeded(rewardDto.getPointsNeeded());
        return rewardRepository.save(reward);
    }

    public Reward updateReward(int id, RewardDto rewardDto) {
        Reward reward = getRewardById(id);
        reward.setMessage(rewardDto.getMessage());
            reward.setPointsNeeded(rewardDto.getPointsNeeded());
        return rewardRepository.save(reward);
    }

    public void deleteReward(int id) {
        rewardRepository.deleteById(id);
    }

    public int calculateTotalPoints() {
        List<Task> allTasks = taskRepository.findAll();
        int totalPoints = 0;
        for (Task task : allTasks) {
            if (task.isCompleted()) {
                totalPoints += task.getPoints();
            }
        }
        return totalPoints;
    }

    public List<RewardDto> getUnlockedRewards() {
        int totalPoints = calculateTotalPoints();
        List<Reward> allRewards = rewardRepository.findAll();
        List<RewardDto> unlockedRewards = new ArrayList<>();
        for (Reward reward : allRewards) {
            if (reward.getPointsNeeded() <= totalPoints) {
                RewardDto rewardDto = new RewardDto();
                rewardDto.setId(reward.getId());
                rewardDto.setMessage(reward.getMessage());
                rewardDto.setPointsNeeded(reward.getPointsNeeded());
                unlockedRewards.add(rewardDto);
            }
        }
        return unlockedRewards;
    }
}

