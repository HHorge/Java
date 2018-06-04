package stateandbehavior;

import java.util.Arrays;

public class Digit{
	int value;
	int base;
	String letters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	char[] ch=letters.toCharArray();
	
	
	public Digit(int baseValue) {
		 value = 0;
		 base = baseValue;
	}
	
	
	int getValue() {
		return value;
	}
	boolean increment() {
		value += 1;
		if(value == base) {
			value = 0;
			return true; 
		}
		return false;		 
	}
	int getBase() {
		return base;
		
	}
	public char numberToLetter() {
	    
		if(getValue() % 10 >= 0 && getValue() >= 10) {
			
			return ch[getValue()];
		}
	    return 0;
	    
	}
	public static void main(String[] args) {
		
		Digit digit = new Digit(16);
		
		for(int x = 0; x<15; x++) {
			digit.increment();
			
			 /*System.out.printf("Value = %d\n", myDigit.getValue()); */
	
			
		}
	
		System.out.println(digit.numberToLetter());
		
		
		System.out.printf("In base %d, %d is represented as %c", digit.getBase(), digit.getValue(), digit.numberToLetter());
}
}
