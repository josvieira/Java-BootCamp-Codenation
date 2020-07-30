package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    Optional<User> findById(@PathVariable Long id){
        return userService.findById(id);
    }

//    @GetMapping(params = "name")
//    List<User> findAccelerationName(@RequestParam("name") String name){
//        return userService.findByAccelerationName(name);
//    }
//
//    @GetMapping(params = "companyId")
//    List<User> findByCompanyId(@RequestParam("companyId") Long companyId){
//        return userService.findByCompanyId(companyId);
//    }
    @GetMapping("/user")
    public List<User> findAll(@RequestParam(required = false) Optional<String> accelerationName,
                              @RequestParam(required = false) Optional<Long> companyId) {
        return accelerationName.map(service::findByAccelerationName)
                .orElseGet(() -> companyId.map(service::findByCompanyId).orElse(new ArrayList<>()));
    }
}
