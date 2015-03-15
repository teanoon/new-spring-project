package com.player.models;

import lombok.Data;

@Data
public class Blog {
	private Long id;
	private String title;
	private Account account;
}
