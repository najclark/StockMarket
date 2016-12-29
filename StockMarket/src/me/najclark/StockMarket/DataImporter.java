package me.najclark.StockMarket;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class DataImporter {

	public static ArrayList<TradingDay> getData(String symbol, int maxDays) {
		ArrayList<TradingDay> quotes = new ArrayList<TradingDay>();
		Calendar c = Calendar.getInstance();
		String url = "http://ichart.finance.yahoo.com/table.csv?s=" + symbol + "&d=" + c.get(Calendar.MONTH) + "&e="
				+ c.get(Calendar.DAY_OF_MONTH) + "&f=" + c.get(Calendar.YEAR) + "&g=d&a=" + 1 + "&b=" + 1 + "&c=" + 1950
				+ "&ignore=.csv";

		Scanner sc = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			sc = new Scanner(new URL(url).openStream());
			sc.nextLine(); // skip first line
			while (sc.hasNext()) {

				line = sc.nextLine();
				// use comma as separator
				String[] data = line.split(cvsSplitBy);

				TradingDay day = new TradingDay();
				day.setDate(data[0]);
				day.setOpen(Double.parseDouble(data[1]));
				day.setHigh(Double.parseDouble(data[2]));
				day.setLow(Double.parseDouble(data[3]));
				day.setClose(Double.parseDouble(data[4]));
				day.setVolume(Double.parseDouble(data[5]));
				day.setAdjClose(Double.parseDouble(data[6]));

				quotes.add(day);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return clamp(reverse(quotes), maxDays);
	}

	private static ArrayList<TradingDay> reverse(ArrayList<TradingDay> list) {
		for (int i = 0, j = list.size() - 1; i < j; i++) {
			list.add(i, list.remove(j));
		}
		return list;
	}

	private static ArrayList<TradingDay> clamp(ArrayList<TradingDay> list, int indexes) {
		ArrayList<TradingDay> clamped = new ArrayList<TradingDay>();
		if (indexes == -1) {
			clamped.addAll(list);
		} else {
			for (int i = list.size() - indexes; i < list.size(); i++) {
				clamped.add(list.get(i));
			}
		}
		return clamped;
	}

}
