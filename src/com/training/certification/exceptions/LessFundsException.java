package com.training.certification.exceptions;
//checked exception
//declare it or you have to handle it
//method throws LessFundsException

public class LessFundsException extends Exception {

	public LessFundsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LessFundsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public LessFundsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LessFundsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public LessFundsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
