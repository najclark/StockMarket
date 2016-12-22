package me.najclark.StockMarket;

public class TradingDay {

	private String date;
	private double open, high, low, close, adjClose;
	private double volume;
	
	public TradingDay(String date, double open, double high, double low, double close, double adjClose, double volume){
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.adjClose = adjClose;
		this.volume = volume;
	}
	
	public TradingDay(){
		this("", 0, 0, 0, 0, 0, 0);
	}

	@Override
	public String toString(){
		return date + ", " + open + ", " + high + ", " + low + ", " + close + ", " + adjClose + ", " + volume;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getAdjClose() {
		return adjClose;
	}

	public void setAdjClose(double adjClose) {
		this.adjClose = adjClose;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	
}
