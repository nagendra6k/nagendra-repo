package com.techfynder.forex.exchange;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techfynder.forex.exchange.entity.Currency;
import com.techfynder.forex.exchange.repository.CurrencyRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ForexExchangeRunner implements CommandLineRunner {

	@Autowired
	CurrencyRepository currencyRepository;

	@Override
	public void run(String... args) throws Exception {

		log.info("ForexExchangeRunner starting..");

		log.info("Deleting all currency values before feeding the data");

		currencyRepository.deleteAll();

		List<Currency> currencies = new ArrayList<>();
		currencies.add(new Currency("EUR"));
		currencies.add(new Currency("USD"));
		currencies.add(new Currency("GBP"));
		currencies.add(new Currency("INR"));
		currencyRepository.saveAll(currencies);

		log.info("data feeding is successfully completed");

	}

}
