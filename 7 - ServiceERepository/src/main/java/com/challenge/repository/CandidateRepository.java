package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {
	
	@Query(value = "SELECT * FROM candidate c where c.user_id = :userId AND c.company_id = :companyId "
			+ "AND c.acceleration_id = :accelerationId", nativeQuery = true)
	public Optional<Candidate> findById(@Param("userId")Long userId, @Param("companyId")Long companyId, @Param("accelerationId")Long accelerationId);
	
	//findByCompanyId: buscar um candidato pelo id da empresa 
	@Query(value= "Select * From candidate c where c.company_id = :id", nativeQuery = true)
	public List<Candidate> findByCompanyId(@Param("id")Long id);
	
	//findByAccelerationId: buscar candidatos de uma aceleração
	//com essa descrição não fica claro se devemos retornar registros da tabela Candidate ou User
	@Query(value = "SELECT * FROM candidate c where c.acceleration_id = :id", nativeQuery = true)
	public List<Candidate> findByAccelerationId(@Param("id")Long id);

}
