package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Person1 implements Named, Comparable<Named>{
	private String givenName;
	private String familyName;
	private String[] nameParts;
	
	
	public Person1(String gn, String fn) {
		this.givenName = gn;
		this.familyName = fn;
	}

	@Override
	public void setGivenName(String gn) {
		
		this.givenName = gn;
		
	}

	@Override
	public String getGivenName() {
	
		return this.givenName;
	}

	@Override
	public void setFamilyName(String fn) {
	
		this.familyName = fn;
	}

	@Override
	public String getFamilyName() {
	
		return this.familyName;
	}

	@Override
	public void setFullName(String n) {

		nameParts = n.split(" ");
		this.givenName = nameParts[0];
		this.familyName = nameParts[1];
		
	}

	@Override
	public String getFullName() {
	
		return this.givenName + " " + this.familyName;
	}
	
	@Override
	public int compareTo(Named arg0) {
	
		return 0;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Named> myList = new ArrayList<Named>();
		
		Person1 p1 = new Person1("Adrian", "Flatner");	
		Person1 p2 = new Person1("Aalvor", "Flatner");

		myList.add(p2);
		myList.add(p1);
		
		NamedComparator nc = new NamedComparator();
		Collections.sort(myList,nc);
		
		for(Named p : myList) {
			System.out.println(p.getFullName());
		}

	}




}
