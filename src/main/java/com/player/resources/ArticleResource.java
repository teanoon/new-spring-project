package com.player.resources;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.springframework.hateoas.ResourceSupport;

import com.player.models.Account;
import com.player.models.Blog;

public class ArticleResource extends ResourceSupport {
	@Getter @Setter private String title;
	@Getter @Setter private String content;
	@Getter @Setter private Blog blog;
	@Getter @Setter private Account account;
	@Getter @Setter private boolean is_public;
	@Getter @Setter private Date created_at;
	@Getter @Setter private Date updated_at;
}
