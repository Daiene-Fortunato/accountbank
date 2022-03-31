package br.com.accountbank.handler;

public class CardAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CardAlreadyExistsException() {
        super("This Card already exists");
    }


}
