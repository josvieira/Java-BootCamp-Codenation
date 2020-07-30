package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Challenge;
@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long>{
	//buscar desafios feitos por um usuario em determinada aceleração
	@Query(value = "SELECT c.id, c.created_at, c.name, c.slug " + 
			"FROM challenge c " + 
			"INNER JOIN submission s ON s.challenge_id = c.id " + 
			"inner join acceleration a on c.id = a.challenge_id " + 
			"where s.user_id = :userId and a.id = :accelerationId", nativeQuery = true) 
	public List<Challenge>  findByAccelerationIdAndUserId(@Param("accelerationId")Long accelerationId, @Param("userId") Long userId);

} 
