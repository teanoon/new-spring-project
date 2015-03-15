package com.player.services;

import java.util.ArrayList;
import java.util.List;

import com.player.models.Article;

public interface ArticleService {
	public List<Article> articles = new ArrayList<Article>();
	public List<Article> all();
	public List<Article> where( String queries );
	public Article find( String queries );
	public Article create( Article data );
	public void update( Long articleId );
	public void destroy( Long articleId );
}
