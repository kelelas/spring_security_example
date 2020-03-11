package com.kelelas.spring_security_example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table( name="user_login",
        uniqueConstraints={@UniqueConstraint(columnNames={"username"})})
public class UserLogin implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    Long id;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(nullable = false)
    private String username;
    @Column
    @Enumerated(EnumType.STRING)
    private RoleType role;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<RoleType> list = new ArrayList<>();
        list.add(role);
        return list;
    }
}