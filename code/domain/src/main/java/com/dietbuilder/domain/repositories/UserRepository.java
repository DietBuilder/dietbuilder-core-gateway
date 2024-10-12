package com.dietbuilder.domain.repositories;

import com.dietbuilder.domain.documents.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
}
