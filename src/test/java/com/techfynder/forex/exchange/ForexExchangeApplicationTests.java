package com.techfynder.forex.exchange;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.techfynder.forex.exchange.dto.CurrencyQuotesDto;
import com.techfynder.forex.exchange.service.ForexExchangeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ForexExchangeApplicationTests {

	@Autowired
	ForexExchangeService forexExchangeService;

	@Test
	public void contextLoads() {
		CurrencyQuotesDto currencyQuotesDto = forexExchangeService.exchangeCurrencyRates("USD");
		System.out.println(currencyQuotesDto.toString());
	}

}
