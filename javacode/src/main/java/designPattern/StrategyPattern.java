package designPattern;

import java.util.ArrayList;
import java.util.List;

public class StrategyPattern {

	public static void main(String[] args) {
		
		List<Stock> stockList = new ArrayList();

		stockList.add(new Stock("AAPL", 318.65, 10));
		stockList.add(new Stock("MSFT", 166.86, 45));
		stockList.add(new Stock("Google", 99, 12.5));
		stockList.add(new Stock("AMZ", 1866.74, 45));
		stockList.add(new Stock("AAPL", 318.65, 8));
		stockList.add(new Stock("AMZ", 1866.74, 9));
		stockList.add(new Stock("GOOGL", 1480.20, 3.5));
		
//		StockFilter.bySymbol(stockList, "AMZ").forEach(System.out::println);
		
//		System.out.println("-------------------------------------------");
		
//		StockFilter.byPriceAbove(stockList, 300).forEach(System.out::println);
		
		StockFilter.filter(stockList, t -> t.getSymbol().equals("AMZ")).forEach(System.out::println);
		
		System.out.println("-------------------------------------------");
		
		StockFilter.filter(stockList, t -> t.getPrice() > 300).forEach(System.out::println);
	}

}
