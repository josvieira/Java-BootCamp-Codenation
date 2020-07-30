package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//busca candidatos pelo nome da aceleração
	@Query(value= "SELECT u.id, u.created_at, u.email, u.full_name, u.nickname, u.password "
			+ "FROM users u "
			+ "INNER JOIN candidate c ON u.id = c.user_id "
			+ "INNER JOIN acceleration a ON c.acceleration_id = a.id "
			+ "WHERE UPPER(a.name) = upper(:name)", nativeQuery = true)
	public List<User> findAccelerationByName(@Param("name")String name);
	
	//buscar usuários relacionados com uma empresa
	@Query(value="SELECT distinct(u.id), u.created_at, u.email, u.full_name, u.nickname, u.password "
			+ "FROM users u "
			+ "INNER JOIN candidate c ON u.id = c.user_id AND c.company_id = :companyId", nativeQuery = true)
	public List<User> findByCompanyId(@Param("companyId")Long companyId);
}
