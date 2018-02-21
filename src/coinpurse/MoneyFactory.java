package coinpurse;

/**
 * This class is use to create Money.
 * @author Napasai Sutthichutipong
 *
 */
public abstract class MoneyFactory {

	private static MoneyFactory factory;

	/**
	 * Get the instance of MoneyFactory.
	 * @return instance
	 */
	public static MoneyFactory getInstance() {
		if (factory == null) {
			factory = new ThaiMoneyFactory();
		}
		return factory;
	}

	/**
	 * Create object of money.
	 * @param value
	 * @return Valuable of Money
	 */
	public abstract Valuable createMoney(double value);

	/**
	 * create object of money by using String parameter.
	 * @param value
	 * @return Valuable of Money
	 */
	public Valuable createMoney(String value) {
		double val = 0;
		try {
			val = Double.parseDouble(value);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
		return createMoney(val);
	}

	/**
	 * Set MoneyFactory to any country.
	 * @param mf
	 */
	public static void setFactory(MoneyFactory mf) {
		factory = mf;
	}

}
