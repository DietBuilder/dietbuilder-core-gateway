package com.dietbuilder.rabbitmq.mappers;

import com.dietbuilder.rabbitmq.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserDocumentToUserRabbitMqMapper {

    public User sourceToDestination(com.dietbuilder.domain.documents.user.User user) {
        return User.builder()
                .id(user.getUserId())
                .gender(user.getGender().toString())
                .height(user.getHeight())
                .weight(user.getWeight())
                .age(user.getAge())
                .psychicalActivityRatio(user.getPsychicalActivityRatio())
                .numberOfMeals(user.getNumberOfMeals())
                .userGoal(user.getUserGoal().toString())
                .unwantedComestibleProductsIDs(user.getUnwantedComestibleProductsIDs())
                .build();
    }
}
