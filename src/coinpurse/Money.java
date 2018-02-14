package coinpurse;

public class Money implements Valuable{

	protected double value;
	protected String currency;

	/**
	 * Constructor for initialize value and currency of the Money.
	 * @param value
	 * @param currency
	 */
	public Money(double value, String currency) {
		this.value = value;
		this.currency = currency;
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
	 * Compare value of Valuable.
	 * @return true if equal, false if not equal.
	 */
	public boolean equals(Object arg) {
		if (arg == null) return false;
		if (arg.getClass() != this.getClass()) return false;
		Valuable x = (Valuable) arg;
		return this.getValue() == x.getValue() && this.getCurrency().equals(x.getCurrency());
	}

	/**
	 * Order Valuables from the smallest to biggest value.
	 * 
	 * @param coin
	 * @return -1 if a smaller than b, 1 if a bigger than b, 0 if a equal to b.
	 */
	@Override
	public int compareTo(Valuable arg) {
		if (this.getValue() < arg.getValue()) return -1;
		else if (this.getValue() > arg.getValue()) return 1;
		return 0;
	}

}