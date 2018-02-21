package coinpurse;

import static org.junit.Assert.*;
import org.junit.Test;

public class MoneyFactoryTest {

	private MoneyFactory factory = MoneyFactory.getInstance();

	@Test
	public void testSingleton() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory money1 = MoneyFactory.getInstance();
		MoneyFactory money2 = MoneyFactory.getInstance();
		assertTrue(money1 == money2);
	}

	@Test
	public void testSetMoneyFactory() {
		MoneyFactory.setFactory(new MalaiMoneyFactory());
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass(), ThaiMoneyFactory.getInstance().getClass());
		assertEquals(MoneyFactory.getInstance().getClass(), MalaiMoneyFactory.getInstance().getClass());
	}

	@Test
	public void testCreateMoneyDouble() {
		assertNotNull(factory.createMoney(50));
		assertNotEquals(new Coin(5, "Ringgit"), factory.createMoney(5));
		assertEquals(new Coin(5, "Baht"), factory.createMoney(5));
		assertEquals(new Coin(10, "Baht"), factory.createMoney(10));
		assertEquals(new BankNote(100, "Baht", 1000000), factory.createMoney(100));
		assertEquals(new BankNote(500, "Baht", 1000001), factory.createMoney(500));
	}

	@Test
	public void testCreateMoneyString() {
		assertNotNull(factory.createMoney(50));
		assertNotEquals(new Coin(5, "Ringgit"), factory.createMoney("5"));
		assertEquals(new Coin(5, "Baht"), factory.createMoney("5"));
		assertEquals(new Coin(10, "Baht"), factory.createMoney("10"));
		assertEquals(new BankNote(100, "Baht", 1000000), factory.createMoney("100"));
		assertEquals(new BankNote(500, "Baht", 1000001), factory.createMoney("500"));
	}

}
