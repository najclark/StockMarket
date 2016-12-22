package me.najclark.StockMarket.Exceptions;

public class InsufficientFundsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6060133671737871431L;
	
	public InsufficientFundsException(String message){
		super(message);
	}

}
