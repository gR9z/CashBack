package fr.eni.cashregistersimulator;

import java.math.BigDecimal;
import java.util.Scanner;

class CashRegisterSimulator {
    private Scanner inputScanner;
    private Wallet transactionWallet;

    public CashRegisterSimulator() {
        inputScanner = new Scanner(System.in);
        transactionWallet = new Wallet();
    }

    private String promptForInput(String message) {
        System.out.print(message);
        return inputScanner.nextLine().trim();
    }

    private void executeTransactions() {
        initiateChangeTransaction();

        boolean isActive = true;

        while (isActive) {
            System.out.print("\n[g]et another change, [q]uit: ");
            String userChoice = inputScanner.nextLine().trim().toLowerCase();
            
            switch (userChoice) {
            case "g":
                initiateChangeTransaction();
                break;
            case "q":
            	System.out.println("The program has been stopped.");
                isActive = false;
                break;
            default:
                System.out.println("Invalid input: " + userChoice + ". Please choose 'g' to continue or 'q' to quit.");
                break;
            }
        }
    }

    private void initiateChangeTransaction() {
        String amountPaid = promptForInput("Enter amount paid by customer: ");
        String purchasePrice = promptForInput("Enter purchase price: ");
        transactionWallet.returnChange(new BigDecimal(purchasePrice), new BigDecimal(amountPaid));
    }

    public static void main(String[] args) {
        CashRegisterSimulator simulator = new CashRegisterSimulator();
        simulator.executeTransactions();
    }
}
