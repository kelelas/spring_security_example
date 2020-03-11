package com.kelelas.spring_security_example.service;

import com.kelelas.spring_security_example.entity.UserLogin;
import com.kelelas.spring_security_example.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegistrationFormService {
    private final UserRepository userRepository;
    @Autowired
    public RegistrationFormService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveNewUser (UserLogin user){
        //TODO inform the user about the replay email
        // TODO exception to endpoint
        try {
            userRepository.save(user);
        } catch (Exception ex){
            log.info("{Почтовый адрес уже существует}");
        }

    }
}
