package objectstructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {

	private int rows, columns;
	
	private List<List<Cell>> boardList = new ArrayList();
	String numbers = ".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8.....";
	
	
	
	//Lager et brett med Cell-objekter
	public Board(int rows, int columns) {
		this.rows = rows; 
		this.columns = columns; 
		
		for (int i=0; i<rows; i++) {
			boardList.add(new ArrayList<Cell>());
			for (int j=0; j<columns; j++) {
				String cellValue = " . ";//(int)(Math.random()*9);
				boardList.get(i).add(new Cell(cellValue));
			}
		}

	}
	
	//Sjekker om tallet som skrives inn er mellom 1 og 9
	public boolean isValidNumber(String number) {
		
		int number2 = Integer.parseInt(number);
		boolean myNum = number2 > 9 || number2 <= 0;
		
		return myNum ? false : true;
	
	}
	
	//Sjekker om det er "." eller int på brettet
	public boolean isDot(int row, int column) {
		if((getString(row, column).equals("."))) {
			return true;
		}
		return false;
	}
	
	//Sjekker om koordinatene er utenfor brettet
	public boolean isValidMove(int row, int column) {
		
		if(column > 8 || column < 0 || row > 8 || row < 0) {
			return false;
		}
		return true;
	}
	
	//Tar inputen fra brukeren og sjekker om det er konflikt med andre tall
	public void playerMove(String number) {
		
		int row = Integer.parseInt(Character.toString(number.charAt(0)));
		int column = Integer.parseInt(Character.toString(number.charAt(1)));
		String playerNum = Character.toString(number.charAt(2));
		
		move(row, column, playerNum);
		
		if(isDot(row, column)) {
			
			boolean legal = checkLegal(row, column, playerNum);
			//ternary if-statement
			String value = legal ? (" "+ playerNum+" ") : (" "+playerNum+"*");
			boardList.get(row).get(column).setValue(value);
			
			
		}else  {
			System.out.println("Ugyldig posisjon");
		}
		
	}
	
	
	//Sjekker om tallene fra brukeren allerede finnes
	public boolean checkLegal(int row, int column, String number) {
		for(Cell cell: boardList.get(row)) {
			if(cell.getValue().contains(number)) {
				return false;
			}
		}
		
		for(int i = 0; i < boardList.size(); i++) {
			if(boardList.get(i).get(column).getValue().contains(number)) {
				return false;
			}
			
		}
		if(getSquare(boardList, row, column).contains(number)) {
			return false;
		}
		

		
		return true;
	}
	
	//Lager en string av kvadrantene sånn at de kan sjekkes for duplikattall 
	public String getSquare(List<List<Cell>> listArray, int row, int col) {
		String squareAsString = "";
		int rowMod = row % 3;
		int colMod = col % 3;
		
		int rowStart = row - rowMod;
		int colStart = col - colMod;
		
		for (int i = rowStart; i < rowStart+3; i++) {
			for (int j = colStart; j < colStart+3; j++) {
				if(!(listArray.get(i).get(j).getValue().toString().equals(" . "))){
					squareAsString += Character.toString(listArray.get(i).get(j).getValue().charAt(1));
				}
			
			}
		}
		
		
		return squareAsString;
	}
	
	public void move(int row, int column, String number) { 
		if(!(isValidMove(row, column))) {
			throw new IllegalArgumentException("Ugyldig trekk!");
		}
		if (!(isValidNumber(number))) {
			throw new IllegalArgumentException("Ugyldig tall!");
		}
	
		
	}
	
	public void startBoard(String numbers) {
	
		for(int i = 0; i < 9;i++) {
			for(int j = 0; j < 9;j++) {
				
			
			String numb = Character.toString(numbers.charAt((i*9)+j));
			

			numb = numb.contains(".") ? (" " + numb + " ") : ("(" + numb +")");
			
	
			boardList.get(i).get(j).setValue(numb);
			}
			
		}
		
			
	}
	private String getString(int row, int column) {
		String value = Character.toString(this.numbers.charAt((row*9)+column));
		return value;
	}
	
	
	private Cell getCell(int row, int column) {
		return boardList.get(row).get(column);
	}
	
	
	public String toString() {
		String out = ""; 
		for(int i=0; i<this.rows; i++) {
			for(int j=0; j<this.columns; j++) {
				out += getCell(i, j).getValue(); //Bruker intern innkapsling
			}
			out += "\n"; //linjeskift
		}
		return out;
	}
	public static void main(String[] args) {
		Board board = new Board(9,9);
		board.startBoard(".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8.....");
		System.out.println(board);
		board.getSquare(board.boardList, 5, 2).toString();
		Scanner scan = new Scanner(System.in);
		
	
		
		while(true){
		
			String s = scan.next();
			board.playerMove(s);
			System.out.println(board);
					
			}
		
	}
	
}