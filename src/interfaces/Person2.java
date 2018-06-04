package interfaces;

public class Person2 implements Named {

	private String fullName;
	private String[] nameParts;
	
	
	public Person2(String n) {
		
		this.fullName = n;
		this.nameParts = n.split(" ");
		 
	}

	@Override
	public void setGivenName(String gn) {

		this.nameParts[0] = gn;
		this.fullName = gn + " " + this.nameParts[1];
		
	}

	@Override
	public String getGivenName() {
	
		return this.nameParts[0];
		
	}

	@Override
	public void setFamilyName(String fn) {

		this.nameParts[1] = fn;
		this.fullName = nameParts[0] + " " + fn;
	}

	@Override
	public String getFamilyName() {

		return this.nameParts[1];
	}

	@Override
	public void setFullName(String n) {

		this.fullName = n;
		
	}

	@Override
	public String getFullName() {
		return this.fullName;
	}
	public static void main(String[] args) {
		Person2 p2 = new Person2("Halvor Horge");
		System.out.println(p2.getFamilyName());
		System.out.println(p2.getGivenName());
		p2.setFamilyName("Flatner");
		System.out.println(p2.getFamilyName());
		System.out.println(p2.getFullName());
	}

}
