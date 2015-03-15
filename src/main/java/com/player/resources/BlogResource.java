package com.player.resources;

import lombok.Getter;
import lombok.Setter;

import org.springframework.hateoas.ResourceSupport;

import com.player.models.entities.Account;
import com.player.models.entities.Blog;

public class BlogResource extends ResourceSupport {
	@Getter @Setter private String title;
	@Getter @Setter private Account account;

	public Blog toBlog() {
		Blog blog = new Blog();
		blog.setTitle(title);
		blog.setAccount(account);

		return blog;
	}
}
