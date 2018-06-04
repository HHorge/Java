package inheritance;

public class SavingsAccount2 extends AbstractAccount{
	
	int withdrawals;
	double fee;
	
	public SavingsAccount2(int withdrawals, double fee) {
		super();
		this.withdrawals = withdrawals;
		this.fee = fee;
	}
	
	@Override
	void internalWithdraw(double amount) {
		
		if(withdrawals < 1) {
			if(balance - (amount+fee) < 0) {
				throw new IllegalStateException("Insufficient funds1");
			}
			
			balance -= (amount+fee);
			
		
		} else if(balance - amount < 0 ) {
			throw new IllegalStateException("Insufficient funds2");
		}else {
			balance -= amount;
			withdrawals -= 1;
		}
		
		
	}
	public static void main(String[] args) {
		SavingsAccount2 sa = new SavingsAccount2(0, 50);
		
		sa.deposit(200);
		sa.internalWithdraw(50);
		
	}
}
