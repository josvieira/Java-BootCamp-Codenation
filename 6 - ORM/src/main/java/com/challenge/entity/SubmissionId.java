package com.challenge.entity;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class SubmissionId implements Serializable {

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;
	
	@ManyToOne
	@JoinColumn(name = "challenge_id")
	private Challenge challengeId;
	
	
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Challenge getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(Challenge challengeId) {
		this.challengeId = challengeId;
	}

	
	

}
