package com.catch_me_study.catch_me_study.domain.user.repository;


import com.catch_me_study.catch_me_study.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    List<UserEntity> findByIsDeletedFalse();

    Optional<UserEntity> findByIdAndIsDeletedFalse(String id);
}
