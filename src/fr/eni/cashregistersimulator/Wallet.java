package fr.eni.cashregistersimulator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Wallet {

	public void returnChange(BigDecimal itemPrice, BigDecimal amountGiven) {
		if (amountGiven.compareTo(itemPrice) < 0) {
			System.out.println("Not enough money given!");
			return;
		}

		BigDecimal changeToReturn = amountGiven.subtract(itemPrice);
		System.out.println("Change to return: " + changeToReturn + "€");

		LinkedHashMap<CurrencyValue, Integer> change = calculateChange(changeToReturn);

		for (Map.Entry<CurrencyValue, Integer> entry : change.entrySet()) {	
				System.out.println(
						entry.getValue() + " x " + entry.getKey().getValue() + "€ " + entry.getKey().getType());
		}
	}

	private LinkedHashMap<CurrencyValue, Integer> calculateChange(BigDecimal changeToReturn) {
		LinkedHashMap<CurrencyValue, Integer> change = new LinkedHashMap<>();

		CurrencyValue[] values = CurrencyValue.values();
		Arrays.sort(values, (a, b) -> b.getValue().compareTo(a.getValue()));

		int i = 0;
		while (changeToReturn.compareTo(BigDecimal.ZERO) > 0 && i < values.length) {
			CurrencyValue currency = values[i];
			BigDecimal[] divAndRemainder = changeToReturn.divideAndRemainder(currency.getValue());
			int count = divAndRemainder[0].intValue(); // Number of times the currency value fits into the remaining
														// change
			changeToReturn = divAndRemainder[1]; // Remaining change after subtracting the value of this currency

			if (count > 0) {
				change.put(currency, count);
			}
			
			i++;
		}

		return change;
	}
}
