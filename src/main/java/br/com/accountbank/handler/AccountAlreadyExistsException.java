package br.com.accountbank.handler;

public class AccountAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AccountAlreadyExistsException() {
        super("This Account already exists");
    }

}
