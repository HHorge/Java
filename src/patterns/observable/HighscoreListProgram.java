package patterns.observable;

import java.util.Scanner;

public class HighscoreListProgram implements HighscoreListListener {
	HighscoreList myList;
	
	public void init() {
		myList = new HighscoreList(10);
		myList.addHighscoreListListener(this);
		
	}
	
	public void run() {

		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int i = s.nextInt();
			myList.addResult(i);
		}
		s.close();
		
		
	}
	
	public void listChanged(HighscoreList hl, int pos) {
		System.out.printf("The score at position %d changed to %d%n",(pos+1), hl.getElement(pos));
		System.out.println("The complete list is: " + hl);
	}
	
	public static void main(String[] args) {
		HighscoreListProgram hlp = new HighscoreListProgram();
		hlp.init();
		hlp.run();
	}
}
