package com.player.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.player.controllers.BlogController;
import com.player.models.Blog;
import com.player.resources.BlogResource;

public class BlogResourceAsm extends ResourceAssemblerSupport<Blog, BlogResource> {

	public BlogResourceAsm() {
		super(BlogController.class, BlogResource.class);
	}

	@Override
	public BlogResource toResource( Blog blog ) {
		BlogResource blogResource = new BlogResource();
		blogResource.setTitle(blog.getTitle());
		blogResource.setAccount(blog.getAccount());

		return blogResource;
	}
}
