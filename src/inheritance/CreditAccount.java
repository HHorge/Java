package inheritance;

public class CreditAccount extends AbstractAccount {
	
	double creditLine;
	
	public CreditAccount(double creditLine) {
		super();
		if(creditLine > 0) {
			this.creditLine = creditLine;
		} else {
			throw new IllegalArgumentException("Creditline needs to be higher than 0");
		}
	}
	
	public double getCreditLine() {
		return creditLine;
	}
	
	public void setCreditLine(double creditLine) {
		
		if(creditLine < 0) {
			throw new IllegalArgumentException("Creditline needs to be higher than 0");
		} else if(-creditLine > balance) {
			throw new IllegalStateException("Creditline needs to be higher than 0");
		}
		this.creditLine = creditLine;
	}
	
	@Override
	void internalWithdraw(double amount) {
		if(amount > creditLine+balance) {
			throw new IllegalStateException("Insufficient funds");
		}
//		if(balance - amount < -creditLine) {
//			throw new IllegalStateException("Need a higher creditLine");
//		}
		balance -= amount;
	}

}
