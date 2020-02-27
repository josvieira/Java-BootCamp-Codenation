package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	// buscar empresas de uma aceleração
	@Query(value = "SELECT DISTINCT (co.id), co.created_at, co.name, co.slug "
			+ "FROM company co "
			+ "INNER JOIN candidate ca ON co.id = ca.company_id "
			+ "WHERE ca.acceleration_id = :accelerationId", nativeQuery = true)
	public List<Company> findByAccelerationId(@Param("accelerationId")Long accelerationId);
	
	//buscar empresas relacionadas com um usuário
	@Query(value = "SELECT distinct(co.id), co.created_at, co.name, co.slug "
			+ "FROM company co "
			+ "INNER JOIN candidate ca ON ca.company_id = co.id AND ca.user_id = :userId", nativeQuery = true)
	public List<Company> findByUserId(@Param("userId")Long userId);

}
