package com.player.controllers;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.player.models.Blog;
import com.player.services.BlogService;

public class BlogControllerTest {
	@InjectMocks
	private BlogController controller;
	@Mock
	private BlogService blogService;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void showSpecifiedBlog() throws Exception {
		Blog blog = new Blog();
		blog.setTitle("A Brand-new blog");
		blog.setId(1L);

		when(blogService.find("id = 1")).thenReturn(blog);

		mockMvc.perform(get("/blogs/1"))
				.andExpect(jsonPath("$.title", is(blog.getTitle())));
	}

	@Test
	public void givenBlogNotFound() throws Exception {
		mockMvc.perform(get("/blogs/2"))
				.andExpect(status().isNotFound());
	}

	@Test
	public void deleteSuccess() throws Exception {
		mockMvc.perform(delete("/blogs/2"))
				.andExpect(jsonPath("$.type", is("info")));
	}
}
