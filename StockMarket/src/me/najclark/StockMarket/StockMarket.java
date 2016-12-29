package me.najclark.StockMarket;

import java.util.ArrayList;
import java.util.HashMap;

public class StockMarket {

	private HashMap<Integer, Double> movingAvgs;
	private ArrayList<TradingDay> data;
	private int dayIndex = 0;

	public StockMarket(ArrayList<TradingDay> data) {
		this.data = data;
		movingAvgs = new HashMap<Integer, Double>();
		for (int i = 1; i <= 52; i++) {
			movingAvgs.put(i, 0.0);
		}
	}

	public boolean endDay() {
		if (dayIndex + 1 < data.size()) {
			dayIndex++;
			return true;
		}
		return false;
	}

	public StockMarket clone() {
		StockMarket sm = new StockMarket(data);
		sm.setDayIndex(dayIndex - 1);
		sm.endDay();
		sm.setMovingAvgs(movingAvgs);
		return sm;
	}

	public HashMap<Integer, Double> getMovingAvgs() {
		HashMap<Integer, Double> newAvgs = new HashMap<Integer, Double>();
		for (int key : movingAvgs.keySet()) {
			int days = key * 7;
			if (days <= dayIndex) {
				double avg = 0;
				for (int i = dayIndex - days; i < dayIndex; i++) {
					avg += data.get(dayIndex).getClose();
				}
				avg /= days;
				newAvgs.put(key, avg);
			} else {
				newAvgs.put(key, 0.0);
			}
		}
		movingAvgs.clear();
		movingAvgs.putAll(newAvgs);
		return movingAvgs;
	}

	public double benchmark() {
		return (data.get(data.size() - 1).getClose() * 100) / data.get(0).getClose();
	}

	public void setMovingAvgs(HashMap<Integer, Double> avgs) {
		this.movingAvgs = avgs;
	}

	public void setDayIndex(int day) {
		this.dayIndex = day;
	}

	public int getDayIndex() {
		return dayIndex;
	}

	public ArrayList<TradingDay> getData() {
		return data;
	}

	public TradingDay getDay() {
		return data.get(dayIndex);
	}

	public double getClose() {
		return getDay().getClose();
	}

	public double getOpen() {
		return getDay().getOpen();
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
