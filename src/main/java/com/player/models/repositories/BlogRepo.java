package com.player.models.repositories;

import java.util.List;

import com.player.models.entities.Article;
import com.player.models.entities.Blog;

public interface BlogRepo {
	List<Blog> all();
	List<Blog> where( String queries );

	Blog find( int id );
	Blog findByTitle( String title );
	Blog save( Blog data );
	void update( int id, Blog data );
	void destroy( int id );

	Article createArticle( int id, Article data );
	List<Article> articles();
}
