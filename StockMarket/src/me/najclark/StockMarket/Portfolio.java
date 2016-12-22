package me.najclark.StockMarket;

import me.najclark.StockMarket.Exceptions.InsufficientFundsException;
import me.najclark.StockMarket.Exceptions.InsufficientStockQuantity;

public class Portfolio {

	private double money = 0;
	private int stocks = 0;

	public Portfolio(double money) {
		this.money = money;
	}

	public double buyStocks(double price, int quantity) throws InsufficientFundsException {
		double subtotal = price * quantity;
		if (subtotal <= money) {
			money -= subtotal;
			stocks += quantity;
			return money;
		} else {
			throw new InsufficientFundsException("$" + subtotal + " required to purchase " + quantity + " stocks.");
		}
	}

	public double sellStocks(double price, int quantity) throws InsufficientStockQuantity {
		double balance = price * quantity;
		if (quantity <= stocks && quantity > 0) {
			money += balance;
			stocks -= quantity;
			return money;
		} else {
			throw new InsufficientStockQuantity(
					"You can't sell " + quantity + " stocks while only having " + stocks + ".");
		}
	}

	public double buyMaxStocks(double price) {
		int quantity = (int) Math.floor(money / price);
		try {
			buyStocks(price, quantity);
			return quantity;
		} catch (InsufficientFundsException e) {
			// Exception should never be called
			e.printStackTrace();
		}
		return quantity;
	}

	public double sellAllStocks(double price) {
		try {
			return sellStocks(price, stocks);
		} catch (InsufficientStockQuantity e) {
			// Exception should never be called
			e.printStackTrace();
		}
		return money;
	}

	public double getMoney() {
		return money;
	}

	public int getStocks() {
		return stocks;
	}
}
