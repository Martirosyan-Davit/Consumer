package dev.example.dataanalysermicroservice.repository;

import dev.example.dataanalysermicroservice.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserEntity, UUID> {
}
