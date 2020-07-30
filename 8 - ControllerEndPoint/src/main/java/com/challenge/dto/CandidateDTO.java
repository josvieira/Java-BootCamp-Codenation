package com.challenge.dto;

import com.challenge.entity.Candidate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO {

    private Long userId;
    private Long accelerationId;
    private Long companyId;
    private Integer status;
    private String createdAt;

}
