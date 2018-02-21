package coinpurse;

/**
 * Bank note represents money with a fixed value, currency and serial number.
 * @author Napasai Sutthichutipong
 *
 */
public class BankNote extends Money {

	private long serialNumber = 1000000;

	/**
	 * Constructor for initialize value and currency of the Bank notes.
	 * @param value of the coin.
	 * @param currency of the coin.
	 */
	public BankNote(double value, String currency, long serialNumber) {
		super(value, currency);
		this.serialNumber = serialNumber;
	}

	/**
	 * Get serial number of the bank note.
	 * @return serial number
	 */
	public long getSerial() {
		return serialNumber;
	}

	/**
	 * Value, currency and serial number of the bank note.
	 * @return value, currency and serial number of the bank note.
	 */
	public String toString(){
		return String.format("%.2f-%s note [%d]", this.getValue(), this.getCurrency(), serialNumber);
	}

}
