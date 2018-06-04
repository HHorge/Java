package objectstructures;

public class Partner {
	String name;
	Partner partner;
	
	public Partner(String name) {
		this.name = name;
	}
	
	public void setPartner(Partner partner) {
		if(this.partner == partner) {
			return;
		}	
		if(this.partner != null && partner != null) {
			this.partner.partner = null;
			this.partner = partner;
		}
		if(partner == null ) {
			this.partner.partner = null;
			this.partner = null;
			
	
		}else {
			this.partner = partner;
			partner.setPartner(this);
		}
		
	}
	
	public Partner getPartner() {
		
		return this.partner;
	}
	public String getName() {
		return this.name;
	}
	public String toString() {
		
		return getName();
	}
	
	public static void main(String[] args) {
		Partner partnerA = new Partner("Halvor");
		Partner partnerB = new Partner("AstridS");
		Partner partnerC = new Partner("Joakim");
		Partner partnerD = new Partner("Sigrid");
		partnerA.setPartner(partnerB);
		System.out.println(partnerA.getPartner());
		System.out.println(partnerB.getPartner());
		partnerC.setPartner(partnerD);
		partnerA.setPartner(partnerD);
		System.out.println(partnerA.getPartner());
		System.out.println(partnerB.getPartner());
		System.out.println(partnerC.getPartner());
		System.out.println(partnerD.getPartner());
		
		
		
//		partner.setPartner(null);
//		System.out.println(partner.getPartner());
//		System.out.println(partnerA.getPartner());
		
	}

}
