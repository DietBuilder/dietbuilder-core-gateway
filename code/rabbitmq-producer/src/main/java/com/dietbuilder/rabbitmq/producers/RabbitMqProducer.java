package com.dietbuilder.rabbitmq.producers;

import com.dietbuilder.domain.documents.user.User;
import com.dietbuilder.domain.documents.user.UserStatus;
import com.dietbuilder.rabbitmq.mappers.UserDocumentToUserRabbitMqMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
@Slf4j
public class RabbitMqProducer {

    private final RabbitTemplate rabbitTemplate;

    private UserDocumentToUserRabbitMqMapper mapper;

    public User produce(User user) {

        com.dietbuilder.rabbitmq.models.User userToBeSent = mapper.sourceToDestination(user);

        LocalDateTime sentDate = LocalDateTime.now();

        //sending object
        rabbitTemplate.convertAndSend(userToBeSent);

        user = user.toBuilder()
                .sentDate(sentDate)
                .userStatus(UserStatus.SENT)
                .build();

        log.info("User has been sent");

        return user;
    }
}
