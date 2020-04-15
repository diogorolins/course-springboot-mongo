package com.diogorolins.wsmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diogorolins.wsmongo.domains.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
