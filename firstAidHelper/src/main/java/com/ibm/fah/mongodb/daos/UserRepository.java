package com.ibm.fah.mongodb.daos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.fah.mongodb.models.User;


public interface UserRepository extends MongoRepository<User, Long> {

}
