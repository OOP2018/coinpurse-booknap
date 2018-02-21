package coinpurse;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class MoneyFactoryTest {
	
	@Test
	public void testSingleton(){
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory money1 = MoneyFactory.getInstance();
		MoneyFactory money2 = MoneyFactory.getInstance();
		assertTrue(money1 == money2);
	}
	
}
