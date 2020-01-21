package com.sclabs.apigateway.repositories;

import com.sclabs.apigateway.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String> {
    Users findByUsername(String username);
}