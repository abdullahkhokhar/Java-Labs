package ca.utoronto.utm.lab06;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField; 

public class HiByeEventHandler implements EventHandler<ActionEvent> {
	
	private TextField resultTxt;

	public HiByeEventHandler(TextField resultTxt) {
		this.resultTxt = resultTxt;
	}

	// 1) Modify this so that it prints out which button was pressed.
	// Hint: Lookup ActionEvent
	// 2) Modify this so that it sets the text field to which button was pressed
	// Hint: this event handler will need access to a the text field

	public void handle(ActionEvent event) {
		// 1) Print out which button was pressed
		Button hiByeSrc = (Button)event.getSource(); // IS THERE ANOTHER WAY
		System.out.println(hiByeSrc.getText());
		
		// 2) Set the text field to which button was pressed
		this.resultTxt.setText(hiByeSrc.getText());

		System.out.println("button pressed"); // given to us
		return;
	}
}
