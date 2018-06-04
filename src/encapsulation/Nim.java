package encapsulation;

public class Nim {
	private int pileSize = 10;
	private int[] pile = {0,0,0};
	private String result = "";
	
	public Nim(int pileSize) {
		this.pile[0] = pileSize;
		this.pile[1] = pileSize;
		this.pile[2] = pileSize;
	}
	public Nim() {
		this.pile[0] = pileSize;
		this.pile[1] = pileSize;
		this.pile[2] = pileSize;
	}
	public void removePieces(int number, int targetPile) {
		if(isGameOver()) {
			throw new IllegalStateException("The game is over!");
		}
		else if(!(isValidMove(number, targetPile))) {
			throw new IllegalArgumentException("Illegal move!");
		}
		pile[targetPile] -= number;
	}
	
	public boolean isValidMove(int number, int targetPile) {
		
		if(number > pile[targetPile] || number < 1 || targetPile > pile.length-1 || targetPile < 0 || isGameOver()) {
			return false;
		}
		return true;
	}
	
	public boolean isGameOver() {
		if(pile[0] == 0 || pile[1] == 0 || pile[2] == 0) {
			return true;
		}
		return false;
			
	}
	
	public int getPile(int targetPile) {
		return pile[targetPile];
	}
	
	public String toString() {
		for(int x = 0; x <pile.length;x++) {
			result += "Pile " + (x+1) +": " + Integer.toString(pile[x])+"\n";
		}
		
		return result;
	}
	public static void main(String[] args) {
		Nim nim = new Nim();
		nim.removePieces(5, 0);
		System.out.println(nim.pile[0]);
		System.out.println(nim.toString());
		
		
	}
}
