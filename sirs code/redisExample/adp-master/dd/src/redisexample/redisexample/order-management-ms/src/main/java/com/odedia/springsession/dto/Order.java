package com.odedia.springsession.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
	public Order(long id, String name, float amount) {
		this.id=id;
		this.name=name;
		this.amount=amount;
	}
	private Long id;
	private String name;
	private Float amount;
}