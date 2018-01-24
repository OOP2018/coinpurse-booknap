package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoneyUtil{

	/**
	 * Print all coins on the list.
	 * @param coins list
	 */
	public static void printCoins(List<Coin> coins) {
		for (Coin x : coins) {
			System.out.println(x);
		}
	}
	
	/**
	 * Sort the coins.
	 * @param coins list
	 */
	public static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
	}
	
	/**
	 * Add coins that have the same currency to the list.
	 * @param coins list
	 * @param coins currency
	 * @return list of coins
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> list = new ArrayList<Coin>();
		for (Coin x : coins) {
			if (x.getCurrency().equals(currency)) {
				list.add(x);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {	
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(10.0,"Baht"));
		coins.add(new Coin(24.0,"Baht"));
		coins.add(new Coin(4.5,"Yen"));
		coins.add(new Coin(7.5,"USD"));	
		printCoins(coins);
		sortCoins(coins);
		System.out.println("Sorted");
		printCoins(coins);
	}
	
}
