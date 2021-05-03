package com.meritamerica.assignment2;

public class BankAccount {
		long accountNumber;
		double balance;
		double interestRate;

		BankAccount(long accountNumber, double balance, double interestRate){
			this.accountNumber = accountNumber;
			this.balance = balance;
			this.interestRate = interestRate;
	}
	BankAccount (double balance, double interestRate){
		this.accountNumber = MeritBank.getNextAccountNumber();
		this.balance = balance;
		this.interestRate = interestRate;
	}
	long getAccountNumber() {
		return accountNumber;
	}
	double getBalance() {
		return balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public boolean withdraw(double amount) {
		if (amount<balance) {
			System.out.println(balance-amount);
			balance = balance - amount;
			return true;
		} else return false;
	}
	public boolean deposit(double amount) {
		if (amount>0) {
			System.out.println(balance+amount);
			balance = balance+amount;
			return true;
		}else return false;
	}
	public double futureValue(int years) {
			double factor = 1+interestRate;
			return Math.pow(factor, years) * balance;
	}
}