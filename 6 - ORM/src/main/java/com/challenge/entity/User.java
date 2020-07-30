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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table (name = "user")
@Data
@EntityListeners(AuditingEntityListener.class)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer id;
	
	@Column (name = "full_name")
	@Size(min = 1, max = 100)
	@NotNull
	private String fullName;
	
	@Column
	@NotNull
	@Size(min = 1, max = 100)
	@Email
	private String email;
	
	@Column
	@NotNull
	@Size(min = 1, max = 50)
	private String nickname;
	
	@Column
	@NotNull
	@Size(min = 1, max= 255)
	private String password;
	
	@Column(name = "created_at")
	@NotNull
	@CreatedDate
	private Date createdAt;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Candidate> candidate;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Submission> submission;

	
	
}
