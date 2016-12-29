package me.najclark.StockMarket.test;

import me.najclark.StockMarket.DataImporter;
import me.najclark.StockMarket.Portfolio;
import me.najclark.StockMarket.StockMarket;

public class MarketTest {

	public static void main(String[] args) {
		StockMarket sm = new StockMarket(DataImporter.getData("mcd", 365));
		Portfolio p = new Portfolio(1000);
		while(sm.endDay() == true){
			p.buyMaxStocks(sm.getDay().getClose());
		}
		p.sellAllStocks(sm.getDay().getClose());
		System.out.println("Returns: " + (p.getMoney()/1000 * 100) + "%");
	}

}
