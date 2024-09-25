package com.senayinan.ATM;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AtmApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AtmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner input = new Scanner(System.in);

		ATM atm = new ATM(1000, "1234");//pin and first balance hard coded for now.
		int choice = 0;
		int attempts = 3;
		boolean authenticated = false;

		while (attempts > 0 && !authenticated)	{
			System.out.println("Please enter your pin!");
			String enteredPin = input.nextLine();

			if(atm.validatePin(enteredPin))	{
				System.out.println("PIN accepted.");
				authenticated = true;
			} else {
				attempts--;
				System.out.println("Incorrect PIN. Attempts remaining: " + attempts);
				if (attempts == 0) {
					System.out.println("Too many failed attempts. Exiting...");
					input.close();
					return;
				}
			}
			}


		while (true) {
			System.out.println("ATM Menu: ");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Exit");
			System.out.println("Please enter your choice: ");
			choice = input.nextInt();



			switch (choice)	{
				case 1:
					System.out.println("Your current balance is:" + atm.getBalance());
					break;
				case 2:
					System.out.println("Enter the amount you want to deposit: ");
					double depositAmount = input.nextDouble();
					atm.deposit(depositAmount);
					System.out.println("Amount deposited:" + depositAmount);
					break;
				case 3:
					System.out.println("Enter the amount you want to withdraw:");
					double withdrawAmount = input.nextDouble();
					atm.withdraw(withdrawAmount);
					System.out.println("Amount withdrawn: " + withdrawAmount);
					break;
				case 4:
					System.out.println("Exiting");
					input.close();
					return;
				default:
					System.out.println("Invalid choice, please try again.");
			}
		}

	}
}
