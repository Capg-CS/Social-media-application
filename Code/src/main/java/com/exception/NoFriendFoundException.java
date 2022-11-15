package com.exception;

public class NoFriendFoundException extends Exception {
	
	public NoFriendFoundException(String str) {
		super(str);
	}
	
	@Override
	public String toString() {
		return "No messages found";
	}

}
