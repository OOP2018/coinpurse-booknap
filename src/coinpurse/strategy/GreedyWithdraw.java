package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.Valuable;

/**
 * 
 * @author Napasai Sutthichutipong
 *
 */
public class GreedyWithdraw implements WithdrawStrategy{

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		List<Valuable> list1 = new ArrayList<Valuable>();
		List<Valuable> list2 = new ArrayList<Valuable>();
		if (amount.getValue() <= 0 || amount == null)
			return null;
		double amountNeededToWithdraw = amount.getValue();
		Collections.sort(money);
		Collections.reverse(money);
		for (Valuable x : money) {
			if (x.getCurrency().equals(amount.getCurrency())) {
				list2.add(x);
			}
		}
		for (Valuable y : list2) {
			if (amountNeededToWithdraw >= y.getValue()) {
				list1.add(y);
				amountNeededToWithdraw -= y.getValue();
			}
			if (amountNeededToWithdraw == 0)
				break;
		}
		if (amountNeededToWithdraw != 0)
			return null;
		for (Valuable y : list1)
			money.remove(y);
		return list1;
	}

}
