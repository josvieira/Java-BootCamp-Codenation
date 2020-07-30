package com.challenge.service.interfaces;

import com.challenge.entity.Submission;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.query.Param;

public interface SubmissionServiceInterface extends ServiceInterface<Submission> {
	
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);
	
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);

}
