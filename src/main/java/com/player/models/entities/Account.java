package com.player.models.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Account {
	@Id
	private int id;
	private String loginName;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Date birth;
	private String[] abilities;
	private String gender;
}
