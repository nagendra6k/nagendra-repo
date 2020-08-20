package com.techfynder.forex.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techfynder.forex.exchange.dto.CurrencyQuotesDto;
import com.techfynder.forex.exchange.exception.PropertyRequiredException;
import com.techfynder.forex.exchange.service.ForexExchangeService;

@RestController
@RequestMapping("/api")
public class ForexExchangeController {

	@Autowired
	private ForexExchangeService forexExchangeService;

	@GetMapping("/exchageRates")
	public ResponseEntity<CurrencyQuotesDto> exchangeCurrencyRates(@RequestParam("source") String source) {
		if (source == null || source == "") {
			throw new PropertyRequiredException("Source value is required");
		}
		return new ResponseEntity<>(forexExchangeService.exchangeCurrencyRates(source), HttpStatus.OK);
	}

}
