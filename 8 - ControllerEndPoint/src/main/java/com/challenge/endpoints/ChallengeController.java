package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @GetMapping("/challenge")
    public List<Challenge> findAll(@RequestParam("accelerationId") Long accelerationId, @RequestParam("userId") Long userId){
        return challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
    }
}
