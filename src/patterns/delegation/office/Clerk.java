package patterns.delegation.office;

import java.util.function.BinaryOperator;

public class Clerk implements Employee {
	
	public Clerk(Printer p) {
		
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void printDocument(String document) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTaskCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getResourceCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
