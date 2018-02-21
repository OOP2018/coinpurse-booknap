package coinpurse;

/**
 * 
 * @author Napasai Sutthichutipong
 *
 */
public abstract class MoneyFactory {

	private static MoneyFactory factory;

	public static MoneyFactory getInstance() {
		if (factory == null) {
			factory = new ThaiMoneyFactory();
		}
		return factory;
	}

	public abstract Valuable createMoney(double value);

	public Valuable createMoney(String value) {
		double val = 0;
		try {
			val = Double.parseDouble(value);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
		return createMoney(val);
	}

	public static void setFactory(MoneyFactory mf) {
		factory = mf;
	}

}
