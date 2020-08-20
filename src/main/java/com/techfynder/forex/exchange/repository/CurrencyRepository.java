package com.techfynder.forex.exchange.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.techfynder.forex.exchange.entity.Currency;

@Repository
public interface CurrencyRepository extends MongoRepository<Currency, String> {

}
