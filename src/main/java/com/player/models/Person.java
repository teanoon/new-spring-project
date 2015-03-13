package com.player.models;

import java.util.Date;
import lombok.Data;

@Data
public class Person {
	private String name;
	private Date birth;
	private boolean is_male;
	private String[] abilities;
	
	public int age( int currentYear ){
		return currentYear - 1900;
	}
}
