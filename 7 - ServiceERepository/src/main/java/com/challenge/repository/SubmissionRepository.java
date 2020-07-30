package com.challenge.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Submission;
@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long>{
	//Buscar o maior score de um determinado desafio
	@Query(value = "SELECT MAX(s.score) FROM submission s WHERE s.challenge_id = :challengeId", nativeQuery = true)
	public BigDecimal findSubmissionIdByChallengeMaxScore(@Param("challengeId")Long challengeId);
	
	//buscar submissões de um determinado desafio de uma determinada aceleração
	@Query(value = "SELECT s.created_at, s.score, s.user_id, s.challenge_id "
				+ "FROM submission s "
				+ "INNER JOIN challenge c ON s.challenge_id = c.id "
				+ "INNER JOIN acceleration a ON c.id = a.challenge_id "
				+ "WHERE c.id = :challengeId AND a.id = :accelerationId", nativeQuery = true)
	public List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);
}
