package com.jogsoft.apps.pnr.authservice.repository;

import com.jogsoft.apps.pnr.authservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);

}
