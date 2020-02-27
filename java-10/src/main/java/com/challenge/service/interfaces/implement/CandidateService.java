package com.challenge.service.interfaces.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;

@Service
public class CandidateService implements CandidateServiceInterface {

	@Autowired
	CandidateRepository candidateRepository;
	
	@Override
	public Candidate save(Candidate object) {
		return candidateRepository.save(object);
	}

	@Override
	public Optional<Candidate> findById(CandidateId id) {
		return candidateRepository.findById(id);
	}


	@Override
	public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
		return candidateRepository.findById(userId, companyId, accelerationId);
	}
	
	@Override
	public List<Candidate> findByCompanyId(Long companyId) {
		return candidateRepository.findByCompanyId(companyId);
	}

	@Override
	public List<Candidate> findByAccelerationId(Long accelerationId) {
		return candidateRepository.findByAccelerationId(accelerationId);
	}

}
