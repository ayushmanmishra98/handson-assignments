package com.org.exception;

public class AuthenticationException extends Exception{
public AuthenticationException() {
	super("User cannot be stored");
}
public AuthenticationException(String msg) {
	super(msg);
}
}
