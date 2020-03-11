package com.kelelas.spring_security_example.service;


import com.kelelas.spring_security_example.dto.UserDTO;
import com.kelelas.spring_security_example.dto.UsersDTO;
import com.kelelas.spring_security_example.entity.RoleType;
import com.kelelas.spring_security_example.entity.UserLogin;
import com.kelelas.spring_security_example.repository.UserRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
//    @PostConstruct
//    public void init(){
//        if (!userRepository.findUserByUsername("user2").isPresent()){
//            userRepository.save(UserLogin.builder().username("user2")
//                .password(new BCryptPasswordEncoder().encode("password"))
//                .role(RoleType.ROLE_ADMIN)
//                .accountNonExpired(true)
//                .accountNonLocked(true)
//                .credentialsNonExpired(true)
//                .enabled(true).build());
//        }
//
//    }
    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user " + username + " not found!"));
//        return UserLogin.builder().username(username)
//                .password("{noop}password")
//                .authorities(Collections.singletonList(RoleType.ROLE_USER))
//                .accountNonExpired(true)
//                .accountNonLocked(true)
//                .credentialsNonExpired(true)
//                .enabled(true).build();
    }



    public UsersDTO getAllUsers() {
        //TODO checking for an empty user list
        return new UsersDTO(userRepository.findAll());
    }

}
