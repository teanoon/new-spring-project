package com.player.resources;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;


public class AccountResourceTest {
	private AccountResource accountResource = new AccountResource();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void isAbleToSetGender() {
		accountResource.setGender("female");
		
		assertEquals("female", accountResource.toAccount().getGender());
	}
	
	@Test
	public void isAbleToRestrictGenderString() {
		accountResource.setGender("qwerrew");
		
		assertEquals("secret", accountResource.toAccount().getGender());
	}
}
