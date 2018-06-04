package interfaces;

import java.util.Comparator;


public class NamedComparator implements Comparator<Named> {


	@Override
	public int compare(Named p1, Named p2) {
		// TODO Auto-generated method stub
		
		int compareValue = p1.getFamilyName().compareTo(p2.getFamilyName());
		
		return compareValue == 0 ? p1.getGivenName().compareTo(p2.getGivenName()) : compareValue;
	

	}

	public static void main(String[] args) {
		NamedComparator nc = new NamedComparator();
		Person2 p1 = new Person2("Halvor Horge");
		Person2 p2 = new Person2("Adrian Horge");
		
		System.out.println(nc.compare(p2, p1));
		
	}
}
