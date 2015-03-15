package com.player.services;

import java.util.ArrayList;
import java.util.List;

import com.player.models.Account;
import com.player.models.Blog;

public interface AccountService {
	public List<Account> accounts = new ArrayList<Account>();
	public List<Blog> blogs = new ArrayList<Blog>();
	public List<Account> all();
	public List<Account> where( String queries );
	public Account find( String queries );
	public Account create( Account data );
	public void update( Long accountId );
	public void destroy( Long accountId );
	public Blog createBlog( Long accountId, Blog data );
	public List<Blog> findAllBlogs();
}
