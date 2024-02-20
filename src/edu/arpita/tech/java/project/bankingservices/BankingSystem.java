package edu.arpita.tech.java.project.bankingservices;

public class BankingSystem {

	private double balance;

	public BankingSystem(double initialBalance) {
		if (initialBalance < 0) {
			throw new IllegalArgumentException("Initial balance cannot be negative");
		}
		balance = initialBalance;
	}

	public void deposit(double amount) throws NegativeAmountException {
		if (amount < 0) {
			throw new NegativeAmountException("Cannot deposit a negative amount");
		}
		balance += amount;
	}

	public void withdrawal(double amount) throws NegativeAmountException, InsufficientBalanceException {
		if (amount < 0) {
			throw new NegativeAmountException("Cannot withdraw a negative or 0 amount");
		}
		if (amount > balance) {
			throw new InsufficientBalanceException("Insufficient funds");
		}
		balance -= amount;
	}

	public void transfer(double amount) throws NegativeAmountException, InsufficientBalanceException {
		if (amount < 0) {
			throw new NegativeAmountException("Cannot transfer a negative or 0 amount");
		}
		if (amount > balance) {
			throw new InsufficientBalanceException("Insufficient funds");
		}
		balance -= amount;
	}

	public void checkBalance() {
		System.out.println("Current balance is: " + balance);
	}
}
