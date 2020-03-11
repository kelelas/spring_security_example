package com.kelelas.spring_security_example.dto;

import com.kelelas.spring_security_example.entity.UserLogin;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UsersDTO {
    private List<UserLogin> users;
}