package coinpurse;

/**
 * Coin represents money with a fixed value and currency.
 * @author Napasai Sutthichutipong
 *
 */
public class Coin implements Valuable {

	private double value;
	private String currency;

	/**
	 * Constructor for initialize value and currency of the coins.
	 * @param value of the coin.
	 * @param currency of the coin.
	 */
	public Coin(double value, String currency) {
		if (value > 0) {
			this.value = value;
			this.currency = currency;
		}
	}

	/** 
	 * Get value of the coin. 
	 * @return value
	 */
	@Override
	public double getValue() {
		return value;
	}

	/**
	 * Get currency of the coin. 
	 * @return currency
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

	/**
	 * Compare value of the coins.
	 * @return true if equal, false if not equal.
	 */
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Coin x = (Coin) arg;
		return this.value == x.value && this.currency.equals(x.currency);
	}

	/**
	 * Order coins from the smallest to biggest value.
	 * @param coin
	 * @return -1 if a smaller than b, 1 if a bigger than b, 0 if a equal to b.
	 */
	public int compareTo(Coin coin) {
		if (this.getValue() < coin.getValue())
			return -1;
		if (this.getValue() > coin.getValue())
			return 1;
		else
			return 0;
	}

	/**
	 * Value and currency of the coin.
	 * @return value and currency of the coin.
	 */
	public String toString() {
		return String.format("%.2f-%s", value, currency);
	}

}
