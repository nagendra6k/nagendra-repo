package com.techfynder.forex.exchange.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CurrencyRates implements Serializable {

	private static final long serialVersionUID = 8168427374261279676L;

	private String code;

	private double rate;

	public CurrencyRates(String code, double rate) {
		this.code = code;
		this.rate = rate;
	}
}
