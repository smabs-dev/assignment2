package com.meritamerica.assignment2;

import java.util.Arrays;

public class MeritBank {

	static void addAccountHolder(AccountHolder accountHolder) {
		AccountHolder[] temp = Arrays.copyOf(getAccountHolders(), accountHolders.length + 1);
		temp[temp.length - 1] = accountHolder;
		accountHolders = temp;
	}

	static AccountHolder[] accountHolders;

	static AccountHolder[] getAccountHolders() {
		return accountHolders;
	}

	static CDOffering[] getCDOfferings() {
		return getCDOfferings();
	}

	static CDOffering getBestCDOffering(double depositAmount) {
		double bestIR = -1;
		CDOffering bestCDO = null;
		for (int i = 0; i < cdOfferings.length; i++) {
			CDOffering cdo = cdOfferings[i];
			double interestRate = cdo.getInterestRate();
			if (interestRate > bestIR) {
				bestIR = interestRate;
				bestCDO = cdo;
			}
		}
		return bestCDO;
	}
	static CDOffering getSecondBestCDOffering(double depositAmount) {
		double bestIR = -1;
		CDOffering secondCDO = null; 
		CDOffering bestCDO = null;
		for (int i = 0; i < cdOfferings.length; i++) {
			CDOffering cdo = cdOfferings[i];
			double interestRate = cdo.getInterestRate();
			if (interestRate > bestIR) {
				bestIR = interestRate;
				secondCDO = bestCDO;
				bestCDO = cdo;
			}
		}
		return secondCDO;
	}
	static void clearCDOfferings() {
		cdOfferings = new CDOffering[0];
	}

	static void setCDOfferings(CDOffering[] offerings) {
		cdOfferings = offerings;
	}

	private static CDOffering[] cdOfferings = {};

	static long getNextAccountNumber() {
		accountNumber++;
		return accountNumber;
	}
	static long accountNumber;
	
	static double totalBalances() {
		double CombinedBalance = 0;
		for (int i = 0; i < accountHolders.length; i++) {
			AccountHolder accHolder = accountHolders[i];
			CombinedBalance = CombinedBalance + accHolder.getCombinedBalance();
		}
		return CombinedBalance;
	}
	static double futureValue(double presentValue, double interestRate, int term) {
			double factor = 1+interestRate;
			return Math.pow(factor, term) * presentValue;
	}
}