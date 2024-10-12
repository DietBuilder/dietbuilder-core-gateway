package com.dietbuilder.rest.controllers;

import com.dietbuilder.api.UsersApi;
import com.dietbuilder.domain.documents.user.User;
import com.dietbuilder.domain.documents.user.UserStatus;
import com.dietbuilder.rest.mappers.UserDtoToUserDocumentMapper;
import com.dietbuilder.model.UserDto;
import com.dietbuilder.domain.repositories.UserRepository;
import com.dietbuilder.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController implements UsersApi {

    private UserRepository userRepository;

    private UserService userService;

    private UserDtoToUserDocumentMapper userMapper;

    @Override
    public ResponseEntity<Void> putUserDataToQueue(UserDto userDto) {
        User user = userMapper.sourceToDestination(userDto)
                .toBuilder()
                .userStatus(UserStatus.NOT_SENT)
                .receivedDate(LocalDateTime.now())
                .build();

        log.info("Saving user to database before sending to to RabbitMq");
        userRepository.save(user);

        userService.process(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
