package game;

public class Cell {
	private String value;
	private int row, col;
	
	public Cell(String value) {
		this.value = value;
		
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isEmpty() {
		return value == ".";
	}
	public int getRow() {
		return this.row;
	}
	public int getCol() {
		return this.col;
	}
	public void setPos(int row, int col) {
		this.row = row;
		this.col = col;
	}

}