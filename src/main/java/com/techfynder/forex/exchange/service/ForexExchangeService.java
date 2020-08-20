package com.techfynder.forex.exchange.service;

import com.techfynder.forex.exchange.dto.CurrencyQuotesDto;

public interface ForexExchangeService {

	public CurrencyQuotesDto exchangeCurrencyRates(String source);

}
