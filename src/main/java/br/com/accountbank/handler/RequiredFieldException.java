package br.com.accountbank.handler;

public class RequiredFieldException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public RequiredFieldException(String field) {
		super("The Field %s is mandatory");
	}
}
