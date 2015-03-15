package com.player.models;

import java.util.Date;
import lombok.Data;

@Data
public class Account {
	private String loginName;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Date birth;
	private String[] abilities;
	private String gender;
}
