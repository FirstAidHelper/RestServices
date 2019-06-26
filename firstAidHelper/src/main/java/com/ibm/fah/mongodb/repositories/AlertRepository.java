package com.ibm.fah.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.fah.mongodb.models.Alert;


public interface AlertRepository extends MongoRepository<Alert, String> {

}
