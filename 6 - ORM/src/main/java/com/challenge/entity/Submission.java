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
@Table (name="submission")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Submission {
	
	@EmbeddedId
	private SubmissionId submissionId;
	
	@Column
	@NotNull
	private float score;
	
	@Column(name = "created_at")
	@NotNull
	@CreatedDate
	private Date createdAt;

	public SubmissionId getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(SubmissionId submissionId) {
		this.submissionId = submissionId;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	
}
