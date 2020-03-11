package com.kelelas.spring_security_example.controller;

import com.kelelas.spring_security_example.dto.UserDTO;
import com.kelelas.spring_security_example.entity.RoleType;
import com.kelelas.spring_security_example.entity.UserLogin;
import com.kelelas.spring_security_example.service.RegistrationFormService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class RegistrationFormController {
    RegistrationFormService registrationFormService;
    @Autowired
    public RegistrationFormController(RegistrationFormService registrationFormService) {
        this.registrationFormService = registrationFormService;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "reg")
    public void RegFormController(UserDTO user) {
        registrationFormService.saveNewUser(UserLogin.builder()
                .username(user.getUsername())
                .password(new BCryptPasswordEncoder().encode(user.getPassword()))
                .role(RoleType.ROLE_USER)
                .enabled(true)
                .credentialsNonExpired(true)
                .accountNonLocked(true)
                .accountNonExpired(true)
                .build());
        log.info("{}", user);
    }
}
