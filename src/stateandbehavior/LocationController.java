package stateandbehavior;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LocationController {
	private Location myLocation = new Location();
	
	@FXML
	private Button right;
	@FXML
	private Button left;
	@FXML
	private Button up;
	@FXML
	private Button down;
	@FXML
	private Button xPos;
	@FXML
	private Button yPos;
	@FXML
	private TextField xPosAns;
	@FXML
	private TextField yPosAns;
	
	@FXML
	void handleButtonClickRight() {
		this.myLocation.right();
	}
	@FXML
	void handleButtonClickLeft() {
		this.myLocation.left();
	}
	@FXML
	void handleButtonClickUp() {
		this.myLocation.up();
	}
	@FXML
	void handleButtonClickDown() {
		this.myLocation.down();
	}
	@FXML
	void handleButtonClickGetX() {
		xPosAns.setText(Integer.toString(this.myLocation.getX()));
		
	}
	@FXML
	void handleButtonClickGetY() {
		yPosAns.setText(Integer.toString(this.myLocation.getY()));
		
	}
	@FXML
	private void initialize() {
		yPosAns.setDisable(true);
		xPosAns.setDisable(true);
	}
	

}
