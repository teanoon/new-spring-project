package com.player.resources;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.hateoas.ResourceSupport;

import com.player.models.entities.Blog;

public class BlogListResource extends ResourceSupport {
	@Getter @Setter private List<Blog> blogs = new ArrayList<Blog>();
}
