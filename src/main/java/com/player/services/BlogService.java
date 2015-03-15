package com.player.services;

import java.util.ArrayList;
import java.util.List;

import com.player.models.Article;
import com.player.models.Blog;

public interface BlogService {
	public List<Blog> blogs = new ArrayList<Blog>();
	public List<Article> articles = new ArrayList<Article>();
	public List<Blog> all();
	public List<Blog> where( String queries );
	public Blog find( String queries );
	public Blog create( Blog data );
	public void update( Long blogId );
	public void destroy( Long blogId );
	public Article createArticle( Long blogId, Article data );
	public List<Article> findAllArticles();
}
