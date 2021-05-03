package com.meritamerica.assignment2;

import java.util.Date;

public class CDAccount extends BankAccount {

	private CDOffering cdoffering;

	public CDAccount(CDOffering cdoffering, double balance) {
		super(balance, cdoffering.getInterestRate());
		this.cdoffering = cdoffering;
	}
	int getTerm() {
		return cdoffering.getTerm();
	}
}