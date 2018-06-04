package encapsulation;


public class Account {
	
	
	double balance;
	double interestRate;
	//double interest;
	
	public Account(double initialValue, double interestRate) {
		checkIfNegative(initialValue);
		checkIfNegative(interestRate);
		this.balance = initialValue;
		this.interestRate = interestRate;
		
	}
	
	public void checkIfNegative (double num) {
		if(num < 0) {
			throw new IllegalArgumentException("Number can't be negative");
		}
		
	}
	double getBalance() {
		return balance;
	}
	void addInterest(){
		balance += balance*(interestRate/100);
	}
	void deposit(double amount) {
		checkIfNegative(amount);
		balance += amount;
		
	}
	double getInterestRate() {
		return interestRate;
	}
	void setInterestRate(double interest){
		checkIfNegative(interest);
		interestRate = interest;
	}
	public String toString() {
		
		return Double.toString(this.balance);
	}
	void withdraw(double amount) {
		checkIfNegative(balance-amount);
		if (amount < balance) {
			balance -= amount;
		}
		
	}
	
	public static void main(String[] args) {
		Account account = new Account(200.0, 0.2);
		System.out.println(account.getBalance());
		account.deposit(100.00);
		System.out.println(account.getBalance());
		account.setInterestRate(0.2);
		account.addInterest();
		System.out.println(account.getBalance());
		account.withdraw(100);
		System.out.println(account.getBalance());
		System.out.println(account.toString());
	}
	
}

