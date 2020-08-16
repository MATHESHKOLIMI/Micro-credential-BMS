package com.bank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Account;

@Repository
public interface IAccountRepository extends MongoRepository<Account, String> {

	Optional<List<Account>> findByOwnerId(String pan);
	
}
