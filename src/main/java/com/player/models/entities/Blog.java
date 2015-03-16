package com.player.models.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Blog {
	@Id @GeneratedValue
	private int id;
	private String title;
	private Account account;
}
