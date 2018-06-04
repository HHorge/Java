package interfaces;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double>, BinaryOperator<Double> {

	private Iterator<Double> iterator1;
	private Iterator<Double> iterator2;
	private BinaryOperator<Double> operator;
	private Double default1; 
	private Double default2; 


	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2; 
		this.operator = operator;
	}
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator){
	this.iterator1 = iterator1;
	this.iterator2 = iterator2;
	this.operator = operator;
	this.default1 = default1;
	this.default2 = default2;
	}

	@Override
	public boolean hasNext() {
		if(iterator1.hasNext()&&iterator2.hasNext()) {
			return true;
		}
		if (iterator1.hasNext() && !iterator2.hasNext() && default2 != null) {
			return true;
		}
		if (iterator2.hasNext() && !iterator1.hasNext() && default1 != null) {
			return true;
		}
		return false;
	}

	@Override
	public Double next() {
		if(iterator1.hasNext() && iterator2.hasNext()) {
			return operator.apply(iterator1.next(),iterator2.next());
		}
		if(! iterator1.hasNext() && iterator2.hasNext()) {
			return operator.apply(iterator2.next() , default1);
		}
		 if(! iterator2.hasNext()&& iterator1.hasNext()) {
				return operator.apply(iterator1.next() , default2);
			}
	throw new NoSuchElementException();
		
	}
	
	@Override
	public Double apply(Double t, Double u) {
		
		return t + u;  
	}

	
	
}