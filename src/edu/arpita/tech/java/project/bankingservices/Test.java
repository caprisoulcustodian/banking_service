package edu.arpita.tech.java.project.bankingservices;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);

			System.out.print("Enter initial balance: ");
			double initialBalance = scanner.nextDouble();
			BankingSystem b = new BankingSystem(initialBalance);

			boolean exit = false;
			while (!exit) {
				System.out.println("\nChoose an option:\n");
				System.out.println("1. Deposit");
				System.out.println("2. Withdraw");
				System.out.println("3. Transfer");
				System.out.println("4. Exit");
				System.out.print("\nEnter your choice: \n");

				int choice = scanner.nextInt();
				double amount;

				switch (choice) {
				case 1:
					System.out.print("Enter amount to deposit: ");
					amount = scanner.nextDouble();
					b.deposit(amount);
					System.out.println("Deposited amount is: " + amount);
					b.checkBalance();
					break;
				case 2:
					System.out.print("Enter amount to withdraw: ");
					amount = scanner.nextDouble();
					b.withdrawal(amount);
					b.checkBalance();
					break;
				case 3:
					System.out.print("Enter amount to transfer: ");
					amount = scanner.nextDouble();
					b.transfer(amount);
					b.checkBalance();
					break;
				case 4:
					exit = true;
					System.out.println("You exit from your banking service. Thank You, Come Again.");
					break;
				default:
					System.out.println("Invalid choice. Please enter a number between 1 and 4.");
					break;
				}
			}
			scanner.close();
		} catch (NegativeAmountException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (InsufficientBalanceException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
