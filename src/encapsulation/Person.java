package encapsulation;

import java.util.Arrays;
import java.util.Date;


public class Person {
	private String name;
	private String email;
	private Date birthday;
	private char gender;
	private String[] countryCodes = {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		checkName(name);
		this.name = name;
	}
	
	public boolean isAlpha(String name) {
		
	    return name.matches("[a-z A-Z]+");
	}
	public void checkName(String name) {
		String[] parts = name.split(" ");
		
		
		if((parts.length != 2 || parts[0].length() < 2 || parts[1].length() < 2) || !isAlpha(name)){
			throw new IllegalArgumentException("First/Last name has to be longer than 2 letters");
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		checkEmail(email);
		this.email = email;
	}
	public void checkEmail(String email) {
		email.toLowerCase();
		String[] mailParts = email.split("\\.");
		String[] mailParts2 = mailParts[1].split("\\@");
		
		String name2 = this.name.toLowerCase();
		String[] nameParts = name2.split(" ");
		
		if (mailParts.length != 3 || !(nameParts[0].equals(mailParts[0])) || !(nameParts[1].equals(mailParts2[0]))) {
			throw new IllegalArgumentException("Du har for mange, eller for få punktum. Eller så er navnet i eposten feil.");
		}
		if (!(mailParts[1].contains("@")) || mailParts[0].length() < 2 || mailParts2[0].length() < 2 || !(Arrays.asList(countryCodes).contains(mailParts[2]))) {
			throw new IllegalArgumentException("Skriv inn en gyldig epost (fornavn.etternavn@domene.landskode)");
		}
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		checkBirthday(birthday);
		this.birthday = birthday;
	}
	public void checkBirthday(Date birthday) {
		Date today = new Date();
		if(today.before(birthday)) {
			throw new IllegalArgumentException("Ugyldig dato");
		}
	}
	public char getGender() {
		return gender;
	}
	public void checkGender(char gender) {
		if (gender != 'M' && gender != 'F' && gender != '\0') {
			throw new IllegalArgumentException("Gender must be M, F, or \0");
		}
	}
	public void setGender(char gender) {
		checkGender(gender);
		this.gender = gender;
	}
	
	public static void main(String[] args) {
		//Date date = new Date();
		Person person = new Person();
		person.setName("Halvor Horge");
		System.out.println(person.getName());
		person.setGender('M');
		person.setEmail("halvor.horge@gmail.no");
		System.out.println(person.getEmail());
		//System.out.println(date.getHourOfDay());
	}

}
