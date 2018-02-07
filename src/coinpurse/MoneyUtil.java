package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MoneyUtil{

	/**
	 * Print all coins on the list.
	 * @param coins list
	 */
	public static void printValuable(List<Valuable> valuable) {
		for (Valuable x : valuable) {
			System.out.println(x);
		}
	}
	
	/**
	 * Sort the coins.
	 * @param coins list
	 */
	public static void sortValuable(List<Valuable> valuable) {
		Comparator<Valuable> comp = new ValueComparator();
		Collections.sort(valuable,comp);
	}
	
	/**
	 * Add coins that have the same currency to the list.
	 * @param coins list
	 * @param coins currency
	 * @return list of coins
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> money, String currency) {
		List<Valuable> list = new ArrayList<Valuable>();
		for (Valuable x : money) {
			if (x.getCurrency().equals(currency)) {
				list.add(x);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {	
		List<Valuable> valuable = new ArrayList<Valuable>();
		valuable.add(new Coin(10.0,"Baht"));
		valuable.add(new BankNote(100.0,"Yen"));
		valuable.add(new Coin(8.0,"Baht"));
		valuable.add(new Coin(30.5,"USD"));
		valuable.add(new BankNote(10.0,"USD"));
		valuable.add(new Coin(24.5,"Baht"));
		valuable.add(new Coin(5.0,"Baht"));
		valuable.add(new BankNote(20.0,"Baht"));
		valuable.add(new BankNote(5.0,"USD"));
		valuable.add(new BankNote(0.5,"Yen"));
		valuable.add(new Coin(1.0,"Yen"));
		valuable.add(new Coin(50.0,"Won"));
		valuable.add(new Coin(100.0,"Won"));

		printValuable(valuable);
		sortValuable(valuable);
		System.out.println("Sorted");
		printValuable(valuable);
	}
	
}
