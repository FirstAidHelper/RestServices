package com.ibm.fah.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.fah.mongodb.models.User;


public interface UserRepository extends MongoRepository<User, String> {

}
