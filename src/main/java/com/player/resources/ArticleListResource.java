package com.player.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.player.models.Article;

import lombok.Getter;
import lombok.Setter;

public class ArticleListResource extends ResourceSupport {
	@Getter @Setter private List<Article> articles = new ArrayList<Article>();
}
