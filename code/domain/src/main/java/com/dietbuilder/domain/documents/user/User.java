package com.dietbuilder.domain.documents.user;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Builder(toBuilder = true)
public class User {

    @Id
    private Long userId;

    private Gender gender;

    private Double height;

    private Double weight;

    private Integer age;

    private Double psychicalActivityRatio;

    private Integer numberOfMeals;

    private UserGoal userGoal;

    private List<Long> unwantedComestibleProductsIDs;

    private LocalDateTime receivedDate;

    private UserStatus userStatus;

    private LocalDateTime sentDate;
}
