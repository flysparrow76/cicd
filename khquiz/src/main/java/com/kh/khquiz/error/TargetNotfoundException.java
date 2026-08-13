package com.kh.khquiz.error;

//public class TargetNotfoundException extends Exception {//unchecked Exception
public class TargetNotfoundException extends RuntimeException{//checked Exception
	public TargetNotfoundException() {
		super();
	}
	
	public TargetNotfoundException(String message) {
		super(message);
	}
}
