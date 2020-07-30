package com.challenge.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;


@Entity
@Table(name = "acceleration")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Acceleration {
	@Id
	@GeneratedValue
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

	@NotNull
	@ManyToOne
	@JoinColumn(name = "challenge_id")
	private Challenge challengeId;
	
	@Column(name = "created_at")
	@NotNull
	@CreatedDate
	private Date createdAt;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Candidate> candidate;

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

	public Challenge getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(Challenge challengeId) {
		this.challengeId = challengeId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
