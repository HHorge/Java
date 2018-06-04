package game;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class GameController {


	@FXML
	TextArea console ;

	@FXML
	TextField inputField ;

	//Her maa du deklarerere spillet ditt dersom det heter noe annet enn TicTacToe
	Board game ;

	public void initialize(){
		//Her maa du opprette et objekt av spillet ditt med de argumentene som behoves for det - resten av koden vil gaa ut ifra at du har kalt den game
		game = new Board(9,9);
		game.startBoard(".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8.....");

		console.setText(game.toString());
	}


	@FXML
	public void sendInput(){
		String in = inputField.getText();
		System.out.println(in);
		//Denne metoden kan hete hva som helst, men husk aa endre det her
		game.playerMove(in);
		console.setText(game.toString());

	}
}
