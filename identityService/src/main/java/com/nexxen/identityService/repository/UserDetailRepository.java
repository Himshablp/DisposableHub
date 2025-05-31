package com.nexxen.identityService.repository;

import com.nexxen.identityService.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {
    Optional<UserDetail> findByUsername(String username);
}
