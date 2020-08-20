package com.techfynder.forex.exchange.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document("currency")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Currency implements Serializable {

	private static final long serialVersionUID = 8168427374261279676L;

	@Id
	private String id;

	private String code;

	public Currency(String code) {
		this.code = code;
	}

}
