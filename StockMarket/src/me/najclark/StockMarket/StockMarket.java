package me.najclark.StockMarket;

import java.util.ArrayList;

public class StockMarket {

	ArrayList<TradingDay> data;
	int dayIndex = 0;

	public StockMarket(ArrayList<TradingDay> data) {
		this.data = data;
	}

	public boolean endDay() {
		if (dayIndex + 1 < data.size()) {
			dayIndex++;
			return true;
		}
		return false;
	}

	public TradingDay getDay() {
		return data.get(dayIndex);
	}

	public double getClose() {
		return getDay().getClose();
	}

	public double getAdjClose() {
		return getDay().getAdjClose();
	}

	public String getDate() {
		return getDay().getDate();
	}

	public double getHigh() {
		return getDay().getHigh();
	}

	public double getLow() {
		return getDay().getLow();
	}

	public double getVolume() {
		return getDay().getVolume();
	}
}
