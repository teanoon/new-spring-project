package com.player.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.player.exceptions.HttpNotFoundException;
import com.player.helpers.Message;
import com.player.models.Blog;
import com.player.resources.BlogListResource;
import com.player.resources.BlogResource;
import com.player.resources.asm.BlogResourceAsm;
import com.player.services.BlogService;

@Controller
@RequestMapping("/blogs")
public class BlogController {
	private final BlogService blogService;
	private final BlogResource blogResource = new BlogResource();

	public BlogController( BlogService blogServ ) {
		blogService = blogServ;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody BlogListResource index() {
		BlogListResource blogList = new BlogListResource();
		blogList.setBlogs(blogService.all());

		return blogList;
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody BlogResource create(@RequestParam(value="title") String title) {
		blogResource.setTitle(title);
		blogService.create(blogResource.toBlog());

		return blogResource;
	}

	@RequestMapping(value = "/{blogId}", method = RequestMethod.GET)
	public @ResponseBody BlogResource show(@PathVariable Long blogId) {
		try {
			String queries = "id = " + blogId;
			Blog blog = blogService.find(queries);

			return new BlogResourceAsm().toResource(blog);
		} catch (Exception e) {
			throw new HttpNotFoundException();
		}
	}

	@RequestMapping(value = "/{blogId}", method = RequestMethod.PATCH)
	public @ResponseBody BlogResource update(@RequestParam(value="title") String title) {
		blogResource.setTitle(title);
		blogService.update(blogResource.toBlog().getId());

		return blogResource;
	}

	@RequestMapping(value = "/{blogId}", method = RequestMethod.DELETE)
	public @ResponseBody Message destroy() {
		Message msg = new Message();
		msg.setType("info");
		msg.setContent("your blog has been deleted!");

		return msg;
	}
}
