package com.techfynder.forex.exchange.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.techfynder.forex.exchange.dto.CurrencyQuotesDto;
import com.techfynder.forex.exchange.dto.CurrencyRates;
import com.techfynder.forex.exchange.entity.CurrencyQuotes;
import com.techfynder.forex.exchange.exception.AccessRestrictedException;
import com.techfynder.forex.exchange.repository.CurrencyQuotesRepository;
import com.techfynder.forex.exchange.repository.CurrencyRepository;
import com.techfynder.forex.exchange.service.ForexExchangeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ForexExchangeServiceImpl implements ForexExchangeService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${currencylayer.api.url}")
	private String apiURL;

	@Value("${access_key}")
	private String accessKey;

	@Autowired
	CurrencyRepository currencyRepository;

	@Autowired
	CurrencyQuotesRepository currencyQuotesRepository;

	@Override
	public CurrencyQuotesDto exchangeCurrencyRates(String source) {

		List<String> currencies = new ArrayList<>();

		currencyRepository.findAll().forEach(c -> currencies.add(c.getCode()));

		log.info("Invoking Currency Exchanger Third part api");

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiURL).queryParam("access_key", accessKey)
				.queryParam("source", source).queryParam("currencies", String.join(",", currencies));

		ResponseEntity<String> response = restTemplate.getForEntity(builder.build().toString(), String.class);

		log.info("Response Body {} ", response.getBody());

		currencyQuotesRepository.deleteAll();

		JsonElement jsonElement = new Gson().fromJson(response.getBody(), JsonElement.class);
		JsonObject jsonObject = jsonElement.getAsJsonObject();

		if (!jsonObject.get("success").getAsBoolean()) {
			throw new AccessRestrictedException(jsonObject.get("error").getAsJsonObject().get("info").getAsString());
		}

		CurrencyQuotes currencyQuotes = new CurrencyQuotes();
		currencyQuotes.setSource(jsonObject.get("source").getAsString());
		currencyQuotes.setTimestamp(jsonObject.get("timestamp").getAsLong());

		List<CurrencyRates> currencyRates = new ArrayList<>();

		JsonObject quotes = jsonObject.get("quotes").getAsJsonObject();
		currencies.forEach(currency -> {
			currencyRates.add(new CurrencyRates(currency, quotes.get(source + currency).getAsDouble()));
		});

		currencyQuotes.setQuotes(currencyRates);

		currencyQuotes = currencyQuotesRepository.save(currencyQuotes);
		CurrencyQuotesDto currencyQuotesDto = new CurrencyQuotesDto();
		BeanUtils.copyProperties(currencyQuotes, currencyQuotesDto);
		return currencyQuotesDto;
	}

}
