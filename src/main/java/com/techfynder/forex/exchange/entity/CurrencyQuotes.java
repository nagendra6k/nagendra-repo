package com.techfynder.forex.exchange.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.techfynder.forex.exchange.dto.CurrencyRates;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document("currency_quotes")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CurrencyQuotes implements Serializable {

	private static final long serialVersionUID = 8168427374261279676L;

	@Id
	private String id;

	private String source;

	private Long timestamp;

	private List<CurrencyRates> quotes;
}
