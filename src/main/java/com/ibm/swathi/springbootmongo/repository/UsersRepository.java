package com.ibm.swathi.springbootmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.swathi.springbootmongo.document.Users;

public interface UsersRepository extends MongoRepository<Users, Integer> {
}
