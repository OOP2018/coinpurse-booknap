package coinpurse;

/**
 * This class use to create Malaysia's Money. 
 * @author Napasai Sutthichutipong
 *
 */
public class MalaiMoneyFactory extends MoneyFactory {

	private static long serialNumber = 1000000;

	/**
	 * Create Malaysia's Money.
	 * @param value
	 * @return Coin or BankNote with "Ringgit" or "Sen" currency.
	 */
	@Override
	public Valuable createMoney(double value) {
		if (value <= 0)
			throw new IllegalArgumentException("value should more than 0");
		if (value == 0.05 || value == 0.1 || value == 0.2 || value == 0.5)
			return new Coin(value * 100, "Sen");
		if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100)
			return new BankNote(value, "Ringgit", serialNumber++);
		throw new IllegalArgumentException(value + " is not a valid currency value");
	}

}
