package com.bootcamp.msbootcoin.repository;

import com.bootcamp.msbootcoin.entity.Bootcoin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcoinRepository extends ReactiveMongoRepository<Bootcoin, Integer> {
}
