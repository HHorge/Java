package inheritance;

public class DebitAccount extends AbstractAccount {

//	public DebitAccount() {
//		super();
//		if(balance < 0) {
//			throw new IllegalStateException("Balance less than 0");
//		}
//	}
	
	@Override
	void internalWithdraw(double amount) {
		if(amount > balance) {
			throw new IllegalStateException("The amount is more than the balance");
		}
		
		balance -= amount; 
		
	}

}
