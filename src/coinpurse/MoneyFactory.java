package coinpurse;

public abstract class MoneyFactory {

	private static MoneyFactory instance;

	public static MoneyFactory getInstance() {
		if (instance == null) {
			return ThaiMoneyFactory.getInstance();
		}
		return instance;
	}

	public abstract Valuable createMoney(double value);

	public Valuable createMoney(String value) {
		double val = 0;
		try {
			val = Double.parseDouble(value);
		} catch (IllegalArgumentException ex) {
			ex.getMessage();
		}
		return createMoney(val);
	}

	public static void setFactory(MoneyFactory f) {
		instance = f;
	}

}
