package encapsulation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AccountController {
	
	Account account = new Account(.0, .2);
	
	@FXML
	private Button balanceB;
	@FXML
	private Button setInterestB;
	@FXML
	private Button depositB;
	@FXML
	private Button withdrawB;
	@FXML
	private TextField balanceF;
	@FXML
	private TextField setInterestF;
	@FXML
	private TextField depositF;
	@FXML
	private TextField withdrawF;
	
	@FXML
	public Double getDoubleFromTF(TextField textField) {
		return Double.parseDouble(textField.getText());
		
	}
	@FXML
	void handleButtonClickBalance() {
		balanceF.setText(Double.toString(Math.round((this.account.getBalance()) * 100.0) / 100.0));
		
	}
	@FXML
	void handleButtonClickInterest() {
		this.account.setInterestRate(getDoubleFromTF(setInterestF));
		this.account.addInterest();
		
	}
	@FXML
	void handleButtonClickDeposit() {
		this.account.deposit(getDoubleFromTF(depositF));
		
	}
	@FXML
	void handleButtonClickWithdraw() {
		this.account.withdraw(getDoubleFromTF(withdrawF));
		
	}

	
}
