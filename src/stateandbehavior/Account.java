package stateandbehavior;

public class Account {
	
	double balance;
	double interestRate;
	
	public void Account(double initialValue, double interestRate) {
		initialValue = 0;
		interestRate = 0.2;
	}
	
	double getBalance() {
		return balance;
	}
	void addInterest(){
		balance += balance*(interestRate/100);
	}
	void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
		}
	}
	double getInterestRate() {
		return interestRate;
	}
	void setInterestRate(double interest){
		
		interestRate = interest;
	}
	public String toString() {
		
		return Double.toString(balance);
	}
	void withdraw(double amount) {
		
	}
	
	public static void main(String[] args) {
		Account account = new Account();
		System.out.println(account.getBalance());
		account.deposit(100.00);
		System.out.println(account.getBalance());
		account.setInterestRate(0.02);
		account.addInterest();
		System.out.println(account.getBalance());
		System.out.println(account.toString());
	}
	
}
