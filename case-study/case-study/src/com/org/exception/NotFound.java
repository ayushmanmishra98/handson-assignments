package com.org.exception;

public class NotFound extends Exception{
public NotFound() {
	super("Not Found");
}
public NotFound(String msg) {
	super(msg);
}
}
