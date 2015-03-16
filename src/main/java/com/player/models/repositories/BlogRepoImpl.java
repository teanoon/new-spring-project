package com.player.models.repositories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.player.models.entities.Article;
import com.player.models.entities.Blog;

@Repository
public class BlogRepoImpl implements BlogRepo {
	@Autowired
	private SessionFactory sessionFactory;
	private List<Blog> blogs;

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> all() {
		blogs = sessionFactory.getCurrentSession()
							  .createQuery("from Blog")
							  .list();

		return blogs;
	}

	@Override
	public List<Blog> where( String queries ) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Blog find( int id ) {
		blogs = sessionFactory.getCurrentSession()
							  .createQuery("from Blog where id = ?")
							  .setParameter(0, id)
							  .list();

		if ( blogs.size() > 0 ) {
			return blogs.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Blog findByTitle( String title ) {
		blogs = sessionFactory.getCurrentSession()
							  .createQuery("from Blog where title = ?")
							  .setParameter(0, title)
							  .list();

		if ( blogs.size() > 0 ) {
			return blogs.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Blog save( Blog data ) {
		sessionFactory.getCurrentSession()
					  .save(data);

		return data;
	}

	// TODO smart update using provided attributes only.
	@Override
	public void update( int id, Blog data ) {
		data.setId( id );
		sessionFactory.getCurrentSession().save( data );
	}

	@Override
	public void destroy( int id ) {
		Blog blog = find( id );
		sessionFactory.getCurrentSession().delete( blog );
	}

	@Override
	public List<Article> articles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article createArticle( int id, Article data ) {
		Blog blog = find(id);
		data.setBlog(blog);
		sessionFactory.getCurrentSession().save(data);

		return data;
	}
}
