package com.sample.dong.repository;

import com.sample.dong.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findUserById(String id);

    Optional<User> findByName(String name);
}
