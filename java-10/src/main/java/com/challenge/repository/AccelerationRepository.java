package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long>{
	
	//findByCompanyId: buscar acelerações vinculadas com uma empresa
	@Query(value="SELECT a.id, a.name, a.slug,challenge_id, a.created_at "
			+ "FROM acceleration a, candidate c "
			+ "where c.company_id = :id AND c.acceleration_id = a.id", nativeQuery = true)
	public List<Acceleration> findByCompanyId(@Param("id")Long id);
}
