package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 * @author Napasai Sutthichutipong
 *
 */
public interface Valuable extends Comparable<Valuable>{

	/**
	 * Get the value of object.
	 * @return value 
	 */
	public double getValue();
	
	/**
	 * Get the currency of object.
	 * @return currency
	 */
	public String getCurrency();
	
}
