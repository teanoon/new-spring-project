package com.player.models.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.player.models.entities.Account;

@Repository
public class AccountRepoImpl implements AccountRepo {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public Account findByAccountName( String name ) {
		List<Account> accounts = new ArrayList<Account>();

		accounts = sessionFactory.getCurrentSession()
								 .createQuery("from Account where loginName = ?")
								 .setParameter(0, name)
								 .list();

		if ( accounts.size() > 0 ) {
			return accounts.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Account findAccount(int id) {
		List<Account> accounts = new ArrayList<Account>();

		accounts = sessionFactory.getCurrentSession()
								 .createQuery("from Account where id = ?")
								 .setParameter(0, id)
								 .list();

		if ( accounts.size() > 0 ) {
			return accounts.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void createAccount(Account data) {
		sessionFactory.getCurrentSession()
					  .save(data);
	}
}
