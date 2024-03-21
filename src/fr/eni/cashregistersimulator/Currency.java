package fr.eni.cashregistersimulator;

import java.math.BigDecimal;

abstract class Currency {
	private final BigDecimal value;
	private final String name;

	protected Currency(BigDecimal value) {
		if (!isValueValidForThisCurrency (value)) {
			throw new IllegalArgumentException("Invalid currency value!");
		}
		this.value = value;
		this.name = generateName(value);
	}

	public BigDecimal getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	protected abstract String generateName(BigDecimal value);
	protected abstract boolean isValueValidForThisCurrency (BigDecimal value);

	@Override
	public String toString() {
	    return getClass().getSimpleName() + " { value: " + value + ", name: " + name + " }";
	}
}
