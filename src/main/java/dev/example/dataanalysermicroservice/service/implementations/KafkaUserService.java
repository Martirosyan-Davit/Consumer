package dev.example.dataanalysermicroservice.service.implementations;

import dev.example.dataanalysermicroservice.entity.user.UserEntity;
import dev.example.dataanalysermicroservice.repository.IUserRepository;
import dev.example.dataanalysermicroservice.service.interfaces.IKafkaUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaUserService implements IKafkaUserService {

    private final IUserRepository userRepository;

    @Override
    public void handle(UserEntity user) {
        log.info("User Object {} was saved", user);
        userRepository.save(user);
    }
}
