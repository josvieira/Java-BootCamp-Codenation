package com.challenge.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name = "challenge")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Challenge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer id;
	
	@Column
	@NotNull
	@Size(min = 1, max = 100)
	private String name;
	
	@Column
	@NotNull
	@Size(min = 1, max = 50)
	private String slug;
	
	@Column(name = "created_at")
	@NotNull
	@CreatedDate
	private Date createdAt;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Acceleration> acceleration;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Submission> submission;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Acceleration> getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(List<Acceleration> acceleration) {
		this.acceleration = acceleration;
	}

	public List<Submission> getSubmission() {
		return submission;
	}

	public void setSubmission(List<Submission> submission) {
		this.submission = submission;
	}
	
	

}
