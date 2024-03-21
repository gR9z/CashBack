package fr.eni.cashregistersimulator;

import java.math.BigDecimal;

public enum CurrencyValue {
	ONE_CENT(new BigDecimal("0.01"), "coin"),
	TWO_CENTS(new BigDecimal("0.02"), "coin"),
	FIVE_CENTS(new BigDecimal("0.05"), "coin"),
	TEN_CENTS(new BigDecimal("0.1"), "coin"),
	TWENTY_CENTS(new BigDecimal("0.2"), "coin"),
	FIFTY_CENTS(new BigDecimal("0.5"), "coin"),
	ONE_EURO(new BigDecimal("1"), "coin"),
	TWO_EUROS(new BigDecimal("2"), "coin"),
	FIVE_EUROS(new BigDecimal("5"), "bill"),
	TEN_EUROS(new BigDecimal("10"), "bill"),
	TWENTY_EUROS(new BigDecimal("20"), "bill"),
	FIFTY_EUROS(new BigDecimal("50"), "bill"),
	ONE_HUNDRED_EUROS(new BigDecimal("100"), "bill"),
	TWO_HUNDRED_EUROS(new BigDecimal("200"), "bill"),
	FIVE_HUNDRED_EUROS(new BigDecimal("500"), "bill");
	
	private final BigDecimal value;
	private final String type;
	
	CurrencyValue(BigDecimal value, String type) {
		this.value = value;
		this.type = type;
	}
	
	public BigDecimal getValue() {
		return value;
	}
	
	public String getType() {
		return type;
	}
	
	public static boolean isValidCurrency(BigDecimal value, String type) {
		for (CurrencyValue currency : values()) {
			if(currency.getValue().equals(value) && currency.getType().equals(type)) {
				return true;
			}
		}
		return false;
	}
}
