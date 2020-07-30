package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationService accelerationService;

    @GetMapping("/acceleration/{id}")
    Optional<Acceleration> findById(@PathVariable Long id){
        return accelerationService.findById(id);
    }

//    @GetMapping(params = "companyId")
//    List<Acceleration> findByCompanyId(@RequestParam("companyId") Long companyId){
//        return accelerationService.findByCompanyId(companyId);
    @GetMapping("/acceleration")
    public List<Acceleration> findAll(@RequestParam Long companyId) {
        return service.findByCompanyId(companyId);
    }
}
