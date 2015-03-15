package com.player.models.repositories;

import com.player.models.entities.Account;

public interface AccountRepo {
	public Account findAccount( int i );
	public Account findByAccountName( String name );
	public void createAccount( Account data );
}
