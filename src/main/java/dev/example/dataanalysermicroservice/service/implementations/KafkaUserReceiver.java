package dev.example.dataanalysermicroservice.service.implementations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.example.dataanalysermicroservice.entity.user.UserEntity;
import dev.example.dataanalysermicroservice.service.interfaces.IKafkaUserReceiver;
import dev.example.dataanalysermicroservice.service.interfaces.IKafkaUserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

@Service
@RequiredArgsConstructor
public class KafkaUserReceiver implements IKafkaUserReceiver {

    private final KafkaReceiver<String, Object> receiver;
    private final IKafkaUserService kafkaUserService;

    @PostConstruct
    private void init() {
        fetch();
    }
    @Override
    public void fetch() {
        Gson gson = new GsonBuilder().create();
        receiver.receive()
                .subscribe(r -> {
                    UserEntity userEntity = gson
                            .fromJson(r.value().toString(), UserEntity.class);
                    kafkaUserService.handle(userEntity);
                    r.receiverOffset().acknowledge();
                });
    }
}
