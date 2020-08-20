package com.techfynder.forex.exchange.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 5965162458113179638L;

	private boolean success;

	private int code;

	private String info;

	public ErrorResponse(int code, String info) {
		super();
		this.code = code;
		this.info = info;
	}
}
