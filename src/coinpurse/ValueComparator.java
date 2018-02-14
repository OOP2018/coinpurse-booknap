package coinpurse;

import java.util.Comparator;

/**
 * Compare two valuables and define which one is more value.
 * @author Napasai Sutthichutipong
 *
 */
public class ValueComparator implements Comparator<Valuable> {
	
	/**
	 * Compare two valuables to each other.
	 * @param valuable a
	 * @param valuable b
	 * @return 1 if a is bigger than b, -1 if a is smaller than b
	 * and 0 if a equals to b.
	 */
	@Override
	public int compare(Valuable a, Valuable b) {
		if (a.getCurrency().equals(b.getCurrency())) {
			if (a.getValue() < b.getValue())
				return -1;
			else if (a.getValue() > b.getValue())
				return 1;
			else if (a.getValue() == b.getValue())
				return 0;
		}
		return a.getCurrency().compareToIgnoreCase(b.getCurrency());
	}

}
