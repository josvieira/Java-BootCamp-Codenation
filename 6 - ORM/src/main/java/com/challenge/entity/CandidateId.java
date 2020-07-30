package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class CandidateId implements Serializable{

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;
	
	@ManyToOne
	@JoinColumn(name = "acceleration_id")
	private Acceleration accelerationId;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company companyId;

	}
	
