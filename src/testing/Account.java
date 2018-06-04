package testing;

import java.util.Collection;
import java.util.Iterator;

public class Account implements Iterable<Double>{

	private double balance;
	private double interestRate;
	private Collection<Double> withdrawals;

	public Account(double balance, double interestRate) {
		validateAmount(balance);
		validateInterestRate(interestRate);
		this.balance = balance;
		this.interestRate = interestRate;
		
	}

	private void validateInterestRate(double interestRate) {
		if (interestRate < 0) {
			throw new IllegalArgumentException("Account can not have negative interest rate");
		}
	}

	private void validateAmount(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Negative amount");
		}
	}

	public double getBalance() {
		return this.balance;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(double interestRate) {
		validateInterestRate(interestRate);
		this.interestRate = interestRate;
	}

	public void deposit(double amount) {
		validateAmount(amount);
		this.balance += amount;
	}

	public void withdraw(double amount) {
		validateAmount(amount);
		balance -= amount;
	}

	public void addInterest() {
		this.balance += this.balance * this.interestRate;
	}
	
	@Override 
	public Iterator<Double> iterator(){
		return withdrawals.iterator();
	}

}
