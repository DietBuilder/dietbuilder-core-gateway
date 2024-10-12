package com.dietbuilder.services;

import com.dietbuilder.domain.documents.user.User;
import com.dietbuilder.rabbitmq.producers.RabbitMqProducer;
import com.dietbuilder.domain.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private RabbitMqProducer rabbitMqProducer;

    public void process(User user) {
        User sentUser = rabbitMqProducer.produce(user);

        userRepository.save(sentUser);
    }

}
