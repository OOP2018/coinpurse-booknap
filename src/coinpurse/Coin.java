package coinpurse;

/**
 * Coin represents money with a fixed value and currency.
 * @author Napasai Sutthichutipong
 *
 */
public class Coin extends Money {

	/**
	 * Constructor for initialize value and currency of the coins.
	 * @param value of the coin.
	 * @param currency of the coin.
	 */
	public Coin(double value, String currency) {
		super(value, currency);
	}

	/**
	 * Value and currency of the coin.
	 * @return value and currency of the coin.
	 */
	public String toString() {
		return String.format("%.2f-%s", this.getValue(), this.getCurrency());
	}

}
