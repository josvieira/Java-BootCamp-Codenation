package com.challenge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table (name = "candidate")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Candidate {
	
	@EmbeddedId
	private CandidateId candidateId;
	
	@Column
	@NotNull
	private Integer status;
	
	@Column(name = "created_at")
	@NotNull
	@CreatedDate
	private Date createdAt;

	public CandidateId getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(CandidateId candidateId) {
		this.candidateId = candidateId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



}
