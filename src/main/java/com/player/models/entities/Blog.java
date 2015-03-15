package com.player.models.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Blog {
	@Id @GeneratedValue
	private Long id;
	private String title;
	private Account account;
}
