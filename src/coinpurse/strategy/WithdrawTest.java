package coinpurse.strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.Money;
import coinpurse.Purse;
import coinpurse.Valuable;

/**
 * 
 * @author Book
 *
 */
public class WithdrawTest {

	private WithdrawStrategy strategy;
	private List<Valuable> list;
	private static final String CURRENCY = "Baht";
	private static final double TOL = 1.0E-6;

	public Money makeMoney(double value) {
		return new Money(value, CURRENCY);
	}

	/**
	 * Code to run before test. Setup the "test fixture".
	 */
	@Before
	public void setUp() {
		strategy = new GreedyWithdraw();
		list = new ArrayList<>();
	}

	@Test
	public void testWithdrawNothing() {
		assertNull(strategy.withdraw(makeMoney(5), list));
		assertNull(strategy.withdraw(makeMoney(10), list));
		assertNull(strategy.withdraw(makeMoney(20), list));
	}

	@Test
	public void testWithdrawZero() {
		assertEquals(strategy.withdraw(new Coin(0, CURRENCY), list), null);
		assertEquals(strategy.withdraw(new Money(0, CURRENCY), list), null);
		assertEquals(strategy.withdraw(new Coin(0, CURRENCY), list), null);
	}

	@Test
	public void testWithdrawEverthing() {
		list.add(makeMoney(1));
		assertEquals(makeMoney(1), strategy.withdraw(makeMoney(1), list).get(0));
		list.add(makeMoney(2));
		assertEquals(makeMoney(2), strategy.withdraw(makeMoney(2), list).get(0));
		list.add(makeMoney(5));
		assertEquals(makeMoney(5), strategy.withdraw(makeMoney(5), list).get(0));
	}

	@Test
	public void testImpossibleWithdraw() {
		list.add(makeMoney(1));
		list.add(makeMoney(5));
		strategy.withdraw(makeMoney(2), list);
		strategy.withdraw(makeMoney(10), list);
		assertNotNull(list);
	}

	@Test
	public void testWithdrawDifferrentCurrency() {
		list.add(new Coin(5, "Baht"));
		list.add(new Coin(5, "Ringgit"));
		assertNotEquals(new Coin(10, "Baht"), strategy.withdraw(new Coin(10, "Baht"), list));
		assertNotEquals(new Coin(10, "Ringgit"), strategy.withdraw(new Coin(10, "Ringgit"), list));
		assertNotEquals(new Coin(5, "Baht"), strategy.withdraw(new Coin(5, "Ringgit"), list));
	}

	@Test
	public void testMultiWithdraw() {
		list.add(makeMoney(1));
		list.add(makeMoney(2));
		list.add(makeMoney(5));
		list.add(makeMoney(10));
		List<Valuable> money1 = strategy.withdraw(new Coin(1, CURRENCY), list);
		assertEquals(1, money1.get(0).getValue(), TOL);
		List<Valuable> money2 = strategy.withdraw(new Coin(2, CURRENCY), list);
		assertEquals(2, money2.get(0).getValue(), TOL);
		List<Valuable> money3 = strategy.withdraw(new Coin(5, CURRENCY), list);
		assertEquals(5, money3.get(0).getValue(), TOL);
		List<Valuable> money4 = strategy.withdraw(new Coin(10, CURRENCY), list);
		assertEquals(10, money4.get(0).getValue(), TOL);
	}

}
