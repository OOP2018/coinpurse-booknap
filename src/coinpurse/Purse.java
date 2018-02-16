package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A purse contains valuable. You can insert valuable, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Napasai Sutthichutipong
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Valuable> money;

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;
	private Comparator<Valuable> comp = new ValueComparator();

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of valuables you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<Valuable>();
	}

	/**
	 * Count and return the number of valuables in the purse. This is the number
	 * of valuables, not their value.
	 * 
	 * @return the number of valuables in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double total = 0;
		for (Valuable x : money)
			total += x.getValue();
		return total;
	}

	/**
	 * Return the capacity of the purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (this.count() >= this.capacity)
			return true;
		else
			return false;
	}

	/**
	 * Insert a valuable into the purse. The valuable is only inserted if the
	 * purse has space for it and the valuable has positive value. No worthless
	 * valuables!
	 * 
	 * @param valuable
	 *            is a Valuable object to insert into purse
	 * @return true if valuable inserted, false if can't insert
	 */
	public boolean insert(Valuable valuable) {
		if (!this.isFull() && valuable.getValue() > 0) {
			money.add(valuable);
			return true;
		} else
			return false;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuables
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		return withdraw(new Money(amount,"Baht"));
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuables
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount that have same currency to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(Valuable amount) {
		List<Valuable> list1 = new ArrayList<Valuable>();
		List<Valuable> list2 = new ArrayList<Valuable>();
		if (amount.getValue() <= 0 || amount.getValue() > getBalance() || amount == null)
			return null;
		double amountNeededToWithdraw = amount.getValue();
		Collections.sort(money, comp);
		Collections.reverse(money);
		for (Valuable x : money) {
			if (x.getCurrency().equals(amount.getCurrency())) {
				list2.add(x);
			}
		}
		for (Valuable y : list2) {
			if (amountNeededToWithdraw >= y.getValue()) {
				list1.add(y);
				amountNeededToWithdraw -= y.getValue();
			}
			if (amountNeededToWithdraw == 0)
				break;
		}
		if (amountNeededToWithdraw != 0)
			return null;
		for (Valuable y : list1)
			money.remove(y);
		Valuable[] array = new Valuable[list1.size()];
		return list1.toArray(array);
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return String.format("This purse have %d valuables with value %.2f", money.size(), this.getBalance());
	}

}
