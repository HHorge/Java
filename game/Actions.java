package game;

public class Actions {
	int row;
	int col;
	String value;
	
	public Actions(int row, int col, String value) {
		this.row = row;
		this.col = col;
		this.value = value;
		
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public String getValue() {
		return value;
	}

}
