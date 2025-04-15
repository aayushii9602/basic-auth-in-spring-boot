package com.auth.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.auth.entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, UUID> {

	public Optional<UserEntity> findByEmail(String email);

}
