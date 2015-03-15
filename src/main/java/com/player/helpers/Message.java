package com.player.helpers;

import lombok.Data;

/*
 * Message object with enum types
 * json-ready
 */

@Data
public class Message {
	private String content;
	private enum Type {
		info, success, alert, error
	}
	private Type type;
	
	public void setType( String typeName ) {
		type = Type.valueOf(typeName);
	}
}
