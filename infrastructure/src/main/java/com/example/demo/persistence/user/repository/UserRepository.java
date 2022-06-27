package com.example.demo.persistence.user.repository;

import com.example.demo.persistence.user.entity.UserEntity;
import com.example.demo.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findFirstByUser(String user);

    Optional<UserEntity> findFirstByUserAndPassword(String user, String password);
}
