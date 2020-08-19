package br.com.itau.mastertech.acesso.access.consumer.service;

import br.com.itau.mastertech.acesso.access.api.model.AccessModel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AccessConsumerService {

    @KafkaListener(topics = "spec4-ayrton-saito-1", groupId = "default")
    public void readMessage(@Payload AccessModel accessModel) {
        System.out.println("message received. client: "+accessModel.getClientId()+" | door: "+accessModel.getDoorId()+" | has Access? "+accessModel.getHasAccess());
    }
}
