package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MoneyUtil {

	/**
	 * Return the larger argument, based on sort order, using the objects' own
	 * compareTo method for comparing.
	 * 
	 * @param args
	 *            one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException
	 *             if no arguments given.
	 */
	public static <E extends Comparable<Valuable>> E max(E... args) {
		try {
			E max = args[0];
			for (int i = 0; i < args.length; i++) {
				if ((args[i].compareTo((Valuable) max)) > 0) {
					max = args[i];
				}
			}
			return max;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Print all coins on the list.
	 * 
	 * @param coins
	 *            list
	 */
	public static void printValuable(List<Valuable> valuable) {
		for (Valuable x : valuable) {
			System.out.println(x);
		}
	}

	/**
	 * Sort the coins.
	 * 
	 * @param coins
	 *            list
	 */
	public static void sortMoney(List<? extends Valuable> valuable) {
		Comparator<Valuable> comp = new ValueComparator();
		Collections.sort(valuable, comp);
	}

	/**
	 * Add coins that have the same currency to the list.
	 * 
	 * @param coins
	 *            list
	 * @param coins
	 *            currency
	 * @return list of coins
	 */
	public static <E extends Valuable> List<E> filterByCurrency(List<E> valuable, String currency) {
		List<E> listFilter = new ArrayList<E>();
		for (E v : valuable) {
			if (v.getCurrency().equals(currency)) {
				listFilter.add(v);
			}
		}
		return listFilter;
	}

	public static void main(String[] args) {
		List<Valuable> valuable = new ArrayList<Valuable>();
		valuable.add(new Coin(10.0, "Baht"));
		valuable.add(new Coin(8.0, "Baht"));
		valuable.add(new Coin(30.5, "USD"));
		valuable.add(new Coin(24.5, "Baht"));
		valuable.add(new Coin(5.0, "Baht"));
		valuable.add(new Coin(1.0, "Yen"));
		valuable.add(new Coin(50.0, "Won"));
		valuable.add(new Coin(100.0, "Won"));

		printValuable(valuable);
		sortMoney(valuable);
		System.out.println("Sorted");
		printValuable(valuable);

		Money m1 = new BankNote(100, "Baht", 1000000);
		Money m2 = new Coin(20, "Baht");
		Money m3 = new BankNote(500, "Baht", 1000000);
		Money max2 = MoneyUtil.max(m1, m2, m3);
		System.out.println(max2);
		List<Coin> coins = Arrays.asList(new Coin(5, "Baht"), new Coin(0.1, "Ringgit"), new Coin(5, "Cent"));
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");
		System.out.println(result);
	}

}
