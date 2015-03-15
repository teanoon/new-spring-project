package com.player.resources;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.player.models.entities.Account;

public class AccountResource extends ResourceSupport {
	@Getter @Setter private String loginName;
	@Getter @Setter private String email;
	private String password;
	@Getter @Setter private String firstName;
	@Getter @Setter private String lastName;
	@Getter @Setter private Date birth;
	@Getter @Setter private String[] abilities;
	private enum Gender {
		secret, male, female
	}
	
	private Gender gender;
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	
	@JsonProperty
	public void setPassword( String pass ) {
		password = pass;
	}
	
	public String getGender() {
		return gender.toString();
	}
	
	public void setGender( String gen ) {
		if (!EnumUtils.isValidEnum(Gender.class, gen)) {
			gen = "secret";
		}
		gender = Gender.valueOf(gen);
	}
	
	public Account toAccount() {
		Account account = new Account();
		account.setLoginName(loginName);
		account.setEmail(email);
		account.setPassword(password);
		account.setFirstName(firstName);
		account.setLastName(lastName);
		account.setBirth(birth);
		account.setAbilities(abilities);
		account.setGender(gender.toString());
		
		return account;
	}
}
