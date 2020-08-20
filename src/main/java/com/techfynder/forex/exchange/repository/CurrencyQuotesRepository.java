package com.techfynder.forex.exchange.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.techfynder.forex.exchange.entity.CurrencyQuotes;

@Repository
public interface CurrencyQuotesRepository extends MongoRepository<CurrencyQuotes, String> {

}
