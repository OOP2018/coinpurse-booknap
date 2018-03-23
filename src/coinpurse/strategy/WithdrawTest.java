package coinpurse.strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.Valuable;

public class WithdrawTest {
	
	private WithdrawStrategy strategy;
	private List<Valuable> list;

	/**
	 * Code to run before test. Setup the "test fixture".
	 */
	@Before
	public void setUp() {
		strategy = new GreedyWithdraw();
		list = new ArrayList<>();
	}
	
	@Test
	public void testWithdrawEverthing() {
		list.clear();
		list.add(new Coin(1,"Baht"));
		list.add(new Coin(2,"Baht"));
		list.add(new Coin(5,"Baht"));
	}
	
	@Test
	public void testImpossibleWithdraw() {
		list.clear();
		assertNull(strategy.withdraw(new Coin(10,"Baht"),list));
		assertNull(strategy.withdraw(new Coin(5,"Baht"),list));
		assertNull(strategy.withdraw(new BankNote(20,"Baht", 1000000),list));
	}
	
	@Test
	public void test() {
		
	}
	
}
