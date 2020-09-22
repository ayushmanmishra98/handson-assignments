package com.hsbc.exception;

public class InsufficientBalanceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException() {
		super("Not enough balance to withdraw");
	}
	
	public InsufficientBalanceException(String msg) {
		super(msg);
	}
}
