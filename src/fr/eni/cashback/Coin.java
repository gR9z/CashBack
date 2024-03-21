package fr.eni.cashback;

import java.math.BigDecimal;

class Coin extends Currency {
	public Coin(BigDecimal value) {
		super(value);
	}

	@Override
	protected String generateName(BigDecimal value) {
		return "💰 of " + value + "€";
	}

	@Override
	protected boolean isValueValidForThisCurrency (BigDecimal value) {
		return CurrencyValue.isValidCurrency(value, "coin");
	}
}
