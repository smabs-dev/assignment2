package com.meritamerica.assignment2;
//This is the template for a new Checking Account
public class CheckingAccount extends BankAccount {
	
	public CheckingAccount(double balance) {
		super(balance, 0.0001);
	}
	@Override
	public String toString() {
		return "CheckingAccount [balance=" + balance + ", Interest Rate=" + interestRate + "Future Value = "
				+ futureValue(3) +"]";
	}
}