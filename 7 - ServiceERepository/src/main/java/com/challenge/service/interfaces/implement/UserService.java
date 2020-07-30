package com.challenge.service.interfaces.implement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User object) {
		return userRepository.save(object);
	}

	@Override
	public Optional<User> findById(Long userId) {
		return userRepository.findById(userId);
	}

	@Override
	public List<User> findByAccelerationName(String name) {
		return userRepository.findAccelerationByName(name);
	}

	@Override
	public List<User> findByCompanyId(Long companyId) {
		return userRepository.findByCompanyId(companyId);
	}

}
