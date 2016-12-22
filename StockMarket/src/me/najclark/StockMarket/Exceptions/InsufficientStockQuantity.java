package me.najclark.StockMarket.Exceptions;

public class InsufficientStockQuantity extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2377882932674916098L;

	public InsufficientStockQuantity(String message){
		super(message);
	}
	
}
