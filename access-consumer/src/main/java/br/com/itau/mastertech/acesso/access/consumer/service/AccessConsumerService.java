package br.com.itau.mastertech.acesso.access.consumer.service;

import br.com.itau.mastertech.acesso.access.api.model.AccessModel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class AccessConsumerService {

    @KafkaListener(topics = "spec4-ayrton-saito-1", groupId = "default")
    public void readMessage(@Payload AccessModel accessModel) {
         try{
            FileWriter fileWriter = new FileWriter("logAccess.csv", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            StringBuilder sb = new StringBuilder();
            sb.append("Client ID,");
            sb.append("DOOR ID,");
            sb.append("HAS ACCESS?");
            sb.append('\n');

            sb.append(accessModel.getClientId());
            sb.append(',');
            sb.append(accessModel.getDoorId());
            sb.append(',');
            sb.append(accessModel.getHasAccess());
            sb.append('\n');

            printWriter.write(sb.toString());
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
