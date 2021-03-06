package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class Board implements Sudoku {

	private int rows, columns;
	private String numbers = makeString();
	private List<List<Cell>> boardList = new ArrayList();
	String fname;
	private Stack<Actions> redo = new Stack<>();
	private Stack<Actions> undo = new Stack<>();

	// Creates string of dots for the initial board
	public String makeString() {
		String dots = "";
		for (int i = 0; i < 81; i++) {
			dots += ".";
		}
		return dots;
	}

	// Creates a board with Cell objects
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;

		for (int i = 0; i < rows; i++) {
			boardList.add(new ArrayList<Cell>());
			for (int j = 0; j < columns; j++) {
				String cellValue = " . ";// (int)(Math.random()*9);
				boardList.get(i).add(new Cell(cellValue));
			}
		}

	}

	// Checks that a number is between 1 and 9
	public boolean isValidNumber(String number) {

		int number2 = Integer.parseInt(number);
		boolean myNum = number2 > 9 || number2 <= 0;

		return myNum ? false : true;

	}

	// Checks if theres a dot or a number on the board
	public boolean isDot(int row, int column) {

		return getString(row, column).equals(".");
	}

	// Checks if the coordinates are outside the board
	public boolean isValidMove(int row, int column) {

		if (column > 8 || column < 0 || row > 8 || row < 0) {
			return false;
		}
		return true;
	}

	// Takes input from the user and checks for conflicts
	public void playerMove(String number) {

		int row = Integer.parseInt(number.substring(0, 1));
		int column = Integer.parseInt(number.substring(1, 2));
		String playerNum = Character.toString(number.charAt(2));

		move(row, column, playerNum);

		if (isDot(row, column)) {

			boolean legal = checkLegal(row, column, playerNum);

			String value = legal ? (" " + playerNum + " ") : (" " + playerNum + "*");

			Actions undoAction = new Actions(row, column, getCell(row, column).getValue());

			undo.push(undoAction);

			getCell(row, column).setValue(value);
			getCell(row, column).setPos(row, column);

		} else {
			System.out.println("Ugyldig posisjon");
		}

	}

	// Checks if the numbers already exists in the grid
	public boolean checkLegal(int row, int column, String number) {
		for (Cell cell : boardList.get(row)) {
			if (cell.getValue().contains(number)) {
				return false;
			}
		}

		for (int i = 0; i < boardList.size(); i++) {
			if (getCell(i, column).getValue().contains(number)) {
				return false;
			}

		}
		if (getSquare(boardList, row, column).contains(number)) {
			return false;
		}

		return true;
	}

	// Makes a string so that the grid can be checked for duplicate numbers
	public String getSquare(List<List<Cell>> listArray, int row, int col) {
		String squareString = "";
		int rowMod = row % 3;
		int colMod = col % 3;

		int rowStart = row - rowMod;
		int colStart = col - colMod;

		for (int i = rowStart; i < rowStart + 3; i++) {
			for (int j = colStart; j < colStart + 3; j++) {
				if (!(listArray.get(i).get(j).getValue().toString().equals(" . "))) {
					squareString += Character.toString(listArray.get(i).get(j).getValue().charAt(1));
				}
			}
		}
		return squareString;
	}

	// Checks if the move and numbers are legal
	public void move(int row, int column, String number) {
		if (!(isValidMove(row, column))) {
			throw new IllegalArgumentException("Ugyldig trekk!");
		}
		if (!(isValidNumber(number))) {
			throw new IllegalArgumentException("Ugyldig tall!");
		}

	}

	// Creates a new board
	public void startBoard(String numbers) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				String numb = Character.toString(numbers.charAt((i * 9) + j));

				numb = numb.contains(".") ? (" " + numb + " ") : ("(" + numb + ")");

				getCell(i, j).setValue(numb);
			}

		}

	}

	// Gets the value of the cell at a given coordinate
	private String getString(int row, int column) {

		String value = Character.toString(this.numbers.charAt((row * 9) + column));

		return value;
	}

	private Cell getCell(int row, int column) {
		return boardList.get(row).get(column);
	}

	public String toString() {
		String out = "   1  2  3   4  5  6   7  8  9\n";
		out += " +---------+---------+---------+\n";
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {

				if (j == 0) {

					out += (i + 1) + "|";
				}

				out += getCell(i, j).getValue(); // Bruker intern innkapsling
				if (j % 3 == 2) {
					out += "|";
				}

			}
			if (i % 3 == 2) {
				out += "\n +---------+---------+---------+";
			}
			out += "\n"; // linjeskift
		}
		return out;
	}

	// Redos the last action made
	public void redo() {
		int row = redo.peek().getRow();
		int col = redo.peek().getCol();

		if (redo.empty()) {

			System.out.println("Cannot redo");

		} else {
			Actions cr = redo.pop();

			getCell(row, col).setValue(cr.getValue());
			;

			undo.push(cr);
		}

	}

	// Undos the last action made
	public void undo() {
		int row = undo.peek().getRow();
		int col = undo.peek().getCol();
		if (undo.empty()) {
			System.out.println("No moves to undo");
		}

		else {
			Actions c = undo.pop();
			Actions redoAction = new Actions(row, col, getCell(row, col).getValue());

			getCell(row, col).setValue(c.getValue());

			redo.push(redoAction);

		}

	}

	public void getInput(String in) {
		playerMove(in);
		toString();

	}

	// Loads a string from a given file
	public void load(String fname) {

		try {
			Scanner inFile = new Scanner(new FileReader(fname));

			String board = inFile.nextLine();
			inFile.close();
			startBoard(board);
			this.numbers = board;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Saves the boardstate to a specified file as a string
	public void save(String fname) {
		String currentBoard = "";
		for (List<Cell> innerList : boardList) {
			for (Cell cell : innerList) {
				currentBoard += cell.getValue().substring(1, 2);
			}

		}

		try {
			PrintWriter file = new PrintWriter(fname);
			file.println(currentBoard);
			file.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Board board = new Board(9, 9);

		System.out.println(board);

		Scanner scan = new Scanner(System.in);

		while (true) {

			String s = scan.next();
			board.playerMove(s);

			System.out.println(board);

		}

	}

}
