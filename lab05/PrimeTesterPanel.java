package ca.utoronto.utm.lab06;

import javafx.scene.layout.FlowPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimeTesterPanel extends FlowPane implements EventHandler<ActionEvent> {
	// Self-Note: this class will be treated as a FlowPlane, and as an event handler for
	// prime tester 2.

	TextField question;
	TextField answer;

	public PrimeTesterPanel() {
		// this refers to the flow plane, and calling set on action on it will invoke handle
		Button isPrime;
		
		question = new TextField();
		question.setPrefColumnCount(10);
		this.getChildren().add(question);
		
		isPrime = new Button("Is Prime?");
		this.getChildren().add(isPrime);
		isPrime.setOnAction(this);

		answer = new TextField();
		answer.setPrefColumnCount(10);
		answer.setDisable(true);
		this.getChildren().add(answer);
	}
	
	// Algorithm for testing prime number 
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
				this.answer.setText("Prime");
			}else {
				this.answer.setText("Not Prime");
			}
				
		} catch(NumberFormatException nfe){
			System.out.println("invalid number"); // Print to the console??
			this.answer.setText("invalid number");
		}
	}

}
