package JavaGrundFortsattning.PRAG_TODO.controller;

import JavaGrundFortsattning.PRAG_TODO.dto.RewardDto;
import JavaGrundFortsattning.PRAG_TODO.entity.Reward;
import JavaGrundFortsattning.PRAG_TODO.service.RewardService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<RewardDto> getAllRewards() {
        return rewardService.getAllRewards();
    }

    @GetMapping("/unlocked")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<RewardDto> getUnlockedRewards() {
        return rewardService.getUnlockedRewards();
    }

    @PostMapping
    public ResponseEntity<?> createReward(@RequestBody RewardDto rewardDto) {
        try {
            Reward reward = rewardService.createReward(rewardDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(reward);
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Kunde inte spara reward i databasen: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ett oväntat fel uppstod: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editReward(@PathVariable int id,
                                        @RequestBody RewardDto rewardDto) {
        try {
            Reward reward = rewardService.updateReward(id, rewardDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(reward);
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Kunde inte ändra reward i databasen: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ett oväntat fel uppstod: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteReward(@PathVariable int id) {
        rewardService.deleteReward(id);
    }
}

