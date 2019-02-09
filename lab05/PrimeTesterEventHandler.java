package ca.utoronto.utm.lab06;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField; // WE CAN ADD THIS RIGHT?

public class PrimeTesterEventHandler implements EventHandler<ActionEvent> {
	
	private TextField resultTxt;
	private TextField question;

	public PrimeTesterEventHandler(TextField question, TextField resultTxt) {
		this.question = question;
		this.resultTxt = resultTxt;
	}
	
	private boolean isPrime(int n){
		for(int i=2;i<n;i++){
			if(n%i == 0) return false;
		}
		return true;
	}

	public void handle(ActionEvent event) {
		try {
			int n=Integer.parseInt(this.question.getText());
			// n is a valid integer in here...
			if(isPrime(n) == true) {
				this.resultTxt.setText("Prime");
			}else {
				this.resultTxt.setText("Not Prime");
			}
				
		} catch(NumberFormatException nfe){
			System.out.println("invalid number"); 
			this.resultTxt.setText("invalid number");
		}
	}
}
