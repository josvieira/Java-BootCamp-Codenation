package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public CandidateDTO findByID(@PathVariable("userId") Long userId, @PathVariable("companyId") Long companyId, @PathVariable("accelerationId") Long accelerationId){
        Optional<Candidate> candidate = candidateService.findById(userId, companyId, accelerationId);
        Candidate ca = new Candidate();
        ca.setId(candidate.get().getId());
        ca.setCreatedAt(candidate.get().getCreatedAt());
        ca.setStatus(candidate.get().getStatus());
        CandidateDTO dto = candidateMapper.map(ca);
        return dto;
    }
    @GetMapping(params = "companyId")
    public List<CandidateDTO> findByCompanyId(@RequestParam("companyId") Long companyId){
        return candidateMapper.map(candidateService.findByCompanyId(companyId));
    }
    @GetMapping(params = "accelerationId")
    public List<CandidateDTO> findByAccelerationId(@RequestParam("accelerationId") Long accelerationId){//não posso usar @Pathvariable
        return candidateMapper.map(candidateService.findByAccelerationId(accelerationId));
    }
}
