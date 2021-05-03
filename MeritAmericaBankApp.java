package com.meritamerica.assignment2;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		CDOffering[] offerings = {
		new CDOffering(1,0.018),
		new CDOffering(2,0.019),
		new CDOffering(3,0.02),
		new CDOffering(5,0.025),
		new CDOffering(10,0.022)
		};
		System.out.println("Hello Merit America!");
MeritBank.setCDOfferings(offerings);
AccountHolder ah1 = new AccountHolder("Flippity", "Dooda", "Hopkins","125295905");
ah1.addCheckingAccount(1000.00);
ah1.addSavingsAccount(10000.00);
ah1.addCheckingAccount(5000.00);
ah1.addSavingsAccount(50000.00);
ah1.addCheckingAccount(50000);
ah1.addSavingsAccount(500000);
ah1.addCheckingAccount(5000);
ah1.addSavingsAccount(50000);
assert(ah1.getNumberOfCheckingAccounts()==3);
assert(ah1.getNumberOfSavingsAccounts()==3);
double CombinedBal = ah1.getCombinedBalance();
ah1.addCDAccount(MeritBank.getBestCDOffering(CombinedBal), CombinedBal);
MeritBank.addAccountHolder(ah1);
AccountHolder ah2 = new AccountHolder("Pappy", "Longjohn", "Silver", "121251025");
ah2.addCheckingAccount(1000);
ah2.addSavingsAccount(10000);
ah2.addCDAccount(MeritBank.getSecondBestCDOffering(CombinedBal), CombinedBal);
MeritBank.addAccountHolder(ah2);
MeritBank.clearCDOfferings();
AccountHolder ah3 = new AccountHolder("Marvin", "The", "Martian", "385864588");
ah3.addCDAccount(MeritBank.getSecondBestCDOffering(CombinedBal), CombinedBal);
assert(ah3.getNumberOfCheckingAccounts()==0);
assert(ah3.getNumberOfSavingsAccounts()==0);
ah3.addCheckingAccount(1000);
ah3.addSavingsAccount(10000);
MeritBank.addAccountHolder(ah3);
System.out.println("Total Balance at MeritBank: " + MeritBank.totalBalances());
	}
}