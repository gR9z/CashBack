package fr.eni.cashback;

import java.math.BigDecimal;

class Bill extends Currency {
	public Bill(BigDecimal value) {
		super(value);
	}
	
	@Override
	protected String generateName(BigDecimal value) {
		return "💶 of " + value + "€";
	}
	
	@Override
	protected boolean isValueValidForThisCurrency (BigDecimal value) {
		return CurrencyValue.isValidCurrency(value, "bill");
	}
}
