package com.player.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.player.models.entities.Blog;
import com.player.models.services.BlogService;

@Controller
@RequestMapping("/blogs")
public class BlogController {
	private final BlogService blogService;

	public BlogController( BlogService blogServ ) {
		blogService = blogServ;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		List<Blog> blogs = blogService.all();

		ModelAndView model = new ModelAndView();
		model.setViewName("index");

		if ( blogs.isEmpty() ) {
			model.addObject("blank", "No blogs found.");
		} else {
			model.addObject(blogs);
		}

		return model;
	}
}
