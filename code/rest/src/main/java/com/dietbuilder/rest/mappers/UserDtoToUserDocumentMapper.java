package com.dietbuilder.rest.mappers;

import com.dietbuilder.domain.documents.user.Gender;
import com.dietbuilder.domain.documents.user.User;
import com.dietbuilder.domain.documents.user.UserGoal;
import com.dietbuilder.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserDocumentMapper {

    public User sourceToDestination(UserDto userDto) {
        return User.builder()
                .userId(userDto.getId())
                .gender(Gender.valueOf(userDto.getGender().getValue()))
                .height(userDto.getHeight())
                .weight(userDto.getWeight())
                .age(userDto.getAge())
                .psychicalActivityRatio(userDto.getPsychicalActivityRatio())
                .numberOfMeals(userDto.getNumberOfMeals())
                .userGoal(UserGoal.valueOf(userDto.getUserGoal().getValue()))
                .unwantedComestibleProductsIDs(userDto.getUnwantedComestibleProductsIDs())
                .build();
    }
}
