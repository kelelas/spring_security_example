package com.kelelas.spring_security_example.repository;

import com.kelelas.spring_security_example.entity.UserLogin;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserLogin, Long> {
    public Optional<UserLogin> findUserByUsername(@NonNull String username);
}
