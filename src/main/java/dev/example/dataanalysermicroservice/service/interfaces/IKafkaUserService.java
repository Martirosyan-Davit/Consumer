package dev.example.dataanalysermicroservice.service.interfaces;


import dev.example.dataanalysermicroservice.entity.user.UserEntity;

public interface IKafkaUserService {

    void handle(UserEntity userEntity);
}
