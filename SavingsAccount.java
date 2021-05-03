package com.meritamerica.assignment2;
public class SavingsAccount extends BankAccount {

	public SavingsAccount(double balance) {
		super(balance, 0.01);
	}
	@Override
	public String toString() {
		return "SavingsAccount [balance=" + balance + ", interestRate=" + interestRate + "]";
	}
}