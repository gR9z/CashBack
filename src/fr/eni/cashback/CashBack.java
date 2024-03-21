package fr.eni.cashback;

import java.math.BigDecimal;

class CashBack {

	 public static void main(String[] args) {
	        Wallet wallet = new Wallet();
	        wallet.returnChange(new BigDecimal("10.50"), new BigDecimal("10.80"));
	        System.out.println("----");
	        wallet.returnChange(new BigDecimal("50"), new BigDecimal("1000"));
	        System.out.println("----");
	        wallet.returnChange(new BigDecimal("100"), new BigDecimal("100"));
	        System.out.println("----");
	        wallet.returnChange(new BigDecimal("958.58"), new BigDecimal("2000"));
	        System.out.println("----");
	        wallet.returnChange(new BigDecimal("1000"), new BigDecimal("100"));
	    }
}
