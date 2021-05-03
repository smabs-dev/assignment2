package com.meritamerica.assignment2;

import java.util.Arrays;

public class AccountHolder {
//instance variables
	
	private String firstName;
	private String middleName; 
	private String lastName;
	private String ssn;
	double openingBalance;
	CheckingAccount[] checkingAccounts = new CheckingAccount[0];
	SavingsAccount[] savingsAccounts = new SavingsAccount[0];
	int numberOfCheckingAccounts = 0;
	int numberOfSavingsAccounts = 0;
	double savingsBalance;
	double offering;
	CDAccount[] cdAccounts = new CDAccount[0];	
	private double checkingAccountOpeningBalance;
	private double savingsAccountOpeningBalance;
	private SavingsAccount savings;
	
// special constructor
public AccountHolder(
		String firstName, 
		String middleName, 
		String lastName,
		String ssn)
{
	this.firstName= firstName;
	this.middleName= middleName;
	this.lastName= lastName;
	this.ssn= ssn;
}
static void addAccountHolder(AccountHolder accountHolder) {
	AccountHolder[] temp = Arrays.copyOf(getAccountHolders(), accountHolders.length + 1);
	temp[temp.length - 1] = accountHolder;
	accountHolders = temp;
}	
static AccountHolder[] accountHolders;

static AccountHolder[] getAccountHolders() {
	return accountHolders;
}

public String getMiddleName() {
	return middleName;
}
public CheckingAccount[] getCheckingAccounts() {
	return checkingAccounts;
}
public SavingsAccount[] getSavingsAccounts() {
	return savingsAccounts;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getSSN() {
	return ssn;
}
public void setSSN(String ssn) {
	this.ssn = ssn;
}
static double totalBalances() {
	double CombinedBalance = 0;
	for (int i = 0; i < accountHolders.length; i++) {
		AccountHolder accHolder = accountHolders[i];
		CombinedBalance = CombinedBalance + accHolder.getCombinedBalance();
	}
	return CombinedBalance;
}
public CheckingAccount addCheckingAccount(double openingBalance) {
		if (openingBalance < 0.0){
			return null;
		}
		if (this.getCheckingBalance() + this.getSavingsBalance() >= 250000.0){
			return null;
		}
		CheckingAccount ca = new CheckingAccount(openingBalance);
		return addCheckingAccount(ca); 
}
public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		CheckingAccount[] temp = Arrays.copyOf(checkingAccounts, checkingAccounts.length + 1);
		temp[temp.length - 1] = checkingAccount;
		checkingAccounts = temp;
	return checkingAccount;
}
public int getNumberOfCheckingAccounts() {
	return checkingAccounts.length;
}
public int getNumberOfSavingsAccounts() {
	return savingsAccounts.length;
}
public double getCheckingBalance() {
	double CombinedBalance = 0;
	for (int i = 0; i < checkingAccounts.length; i++) {
		CheckingAccount ca = checkingAccounts[i];
		CombinedBalance = CombinedBalance + ca.getBalance();
		}
	return CombinedBalance;
	}
public double getSavingsBalance() {
	double CombinedBalance = 0;
	for (int i = 0; i < savingsAccounts.length; i++) {
		SavingsAccount sa = savingsAccounts[i];
		CombinedBalance = CombinedBalance + sa.getBalance();
	}
	return CombinedBalance;
}
public SavingsAccount addSavingsAccount(double openingBalance) {
		if (openingBalance<0.0){
			return null;
		}
		if (this.getCheckingBalance() + this.getSavingsBalance() >= 250000.0){
			return null;
		}
		SavingsAccount sa = new SavingsAccount(openingBalance);
		return addSavingsAccount(sa);
}
public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		SavingsAccount[] temp = Arrays.copyOf(savingsAccounts, savingsAccounts.length + 1);
		temp[temp.length - 1] = savingsAccount;
		savingsAccounts = temp;
	return savingsAccount;
}
public double getCheckingAccountOpeningBalance() {
	return checkingAccountOpeningBalance;
}
public void setCheckingAccountOpeningBalance(double checkingAccountOpeningBalance) {
	this.checkingAccountOpeningBalance = checkingAccountOpeningBalance;
}
public double getSavingsAccountOpeningBalance() {
	return savingsAccountOpeningBalance;
}
public void setSavingsAccountOpeningBalance(double savingsAccountOpeningBalance) {
	this.savingsAccountOpeningBalance = savingsAccountOpeningBalance;
}
CDAccount addCDAccount(CDOffering offering, double openingBalance) {
		if (openingBalance<0.0){
			return null;
		}
		CDAccount cda = new CDAccount(offering, openingBalance);
		return addCDAccount(cda);
}
CDAccount addCDAccount(CDAccount cdAccount) { 
		CDAccount[] temp = Arrays.copyOf(cdAccounts, cdAccounts.length + 1);
		temp[temp.length - 1] = cdAccount;
		cdAccounts = temp;
	return cdAccount;
}
double getCDBalance() {
	double CDBalance = 0;
	for (int i = 0; i < cdAccounts.length; i++) {
		CDAccount cda = cdAccounts[i];
		CDBalance =  CDBalance + cda.getBalance();
	}
	return CDBalance;
}
double getCombinedBalance() {
	return getCheckingBalance() + getSavingsBalance() + getCDBalance();
}    
public CDAccount[] getCDAccounts() {
    return cdAccounts;
}
@Override
public String toString() {
	return "AccountHolder [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", ssn="
			+ ssn + ", checkingAccountOpeningBalance=" + checkingAccountOpeningBalance
			+ ", savingsAccountOpeningBalance=" + savingsAccountOpeningBalance + "]";
	}
}