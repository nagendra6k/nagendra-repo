package com.techfynder.forex.exchange.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CurrencyQuotesDto implements Serializable {

	private static final long serialVersionUID = 8168427374261279676L;

	private boolean success;

	private String source;

	private Long timestamp;

	private List<CurrencyRates> quotes;
}
