package inheritance;

public abstract class AbstractAccount {
	
	protected double balance; 
	

	public AbstractAccount() {
		 balance = 0; 	
	}
	
	public void deposit(double amount) {
		if(amount >= 0) {
			balance += amount;
		}else {
			throw new IllegalArgumentException("Ugyldig beløp");
		}	
	}
  
	
	public void withdraw(double amount) {
		if(amount >= 0) {
			internalWithdraw(amount);
		}else {
			throw new IllegalArgumentException("Ugyldig beløp"); 
		}	 
	}
  
	abstract void internalWithdraw(double amount);
		 
	public double getBalance() {
		return balance; 
	}
}
