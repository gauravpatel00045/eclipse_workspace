package com.sbjpajsp.exception;
/**
 * To manage the error
 * */
public class CustomerNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

    public CustomerNotFoundException() {
        super();
    }

    public CustomerNotFoundException(String customMessage) {
        super(customMessage);
    }
}
