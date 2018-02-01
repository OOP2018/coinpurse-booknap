package coinpurse;

/**
 * Bank note represents money with a fixed value, currency and serial number.
 * @author Napasai Sutthichutipong
 *
 */
public class BankNote implements Valuable {

	private double value;
	private String currency;
	private long serialNumber;
	private static long nextSerialNumber = 1000000;

	/**
	 * Constructor for initialize value and currency of the Bank notes.
	 * @param value of the coin.
	 * @param currency of the coin.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
	}

	/**
	 * Get value of the bank note.
	 * @return value
	 */
	@Override
	public double getValue() {
		return value;
	}

	/**
	 * Get currency of the bank note.
	 * @return currency
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

	/**
	 * Get serial number of the bank note.
	 * @return serial number
	 */
	public long getSerial() {
		return serialNumber;
	}

	/**
	 * Compare value of the bank notes.
	 * @return true if equal, false if not equal.
	 */
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;
		BankNote x = (BankNote) obj;
		return this.value == x.value && this.currency.equals(x.currency);
	}
	
	/**
	 * Value, currency and serial number of the bank note.
	 * @return value, currency and serial number of the bank note.
	 */
	public String toString(){
		return String.format("%.2f-%s note [%d]", value, currency, serialNumber);
	}

}
