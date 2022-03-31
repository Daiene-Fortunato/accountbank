package br.com.accountbank.handler;

public class ExistsCardInAccountException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ExistsCardInAccountException() {
        super("This account has a linked card");
    }


}
