package com.senayinan.ATM;

public class ATM {
    private double balance;
    private String pin;

    public ATM(double firstBalance, String pin) {

        this.balance = firstBalance;
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void checkBalance()    {
        System.out.println("Your balance is: $" + balance);
    }
    public void deposit(double amount)   {
        if(amount > 0) {
            balance += amount;
            System.out.println("You have deposited $" + amount + " Your new balance is: $" + balance);
        }   else {
            System.out.println("The deposit must be greater than zero.");
        }
    }
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -=amount;
            System.out.println("You have withdrawn $" + amount + " Your new balance is: $" + balance);

        } else if (amount > balance)    {
            System.out.println("There is not enough money on your account!");
            }
        else    {
                System.out.println("The amount you're withdrawing must be greater than zero.");
            }
        }

        public boolean validatePin(String enteredPin)   {
        return this.pin.equals(enteredPin);
        }
    }



