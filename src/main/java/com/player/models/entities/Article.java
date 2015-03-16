package com.player.models.entities;

import java.util.Date;

import lombok.Data;

@Data
public class Article {
	private int id;
	private String title;
	private String content;
	private Blog blog;
	private Account account;
	private boolean is_public;
	private Date created_at;
	private Date updated_at;
}
