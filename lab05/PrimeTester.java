package ca.utoronto.utm.lab06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;

public class PrimeTester extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		initUI(stage);
	}

	private void initUI(Stage stage) {

		// Create a layout pane that contains the elements
		HBox pane = new HBox(5);
		pane.setPadding(new Insets(10));
		
		// CONTROLS
		TextField enterPrime = new TextField(); // The text field where user will enter a value
		enterPrime.setPrefColumnCount(20);
		Button isPrime = new Button("Is Prime?"); // Create the button
		TextField result = new TextField(); // The text field in which the result will display
		result.setPrefColumnCount(20);
		result.setDisable(true); // To make sure result text field non-editable
		
		// Put both text fields and buttons on the pane 
		pane.getChildren().add(enterPrime);
		pane.getChildren().add(isPrime);
		pane.getChildren().add(result);

		// Create the buttons
		//Button hi_btn = new Button("Hi");
		//Button bye_btn = new Button("Bye");

		// Put the buttons on the pane
		//pane.getChildren().add(hi_btn);
		//pane.getChildren().add(bye_btn);

		// Create a text field
		//TextField txt = new TextField();
		//txt.setPrefColumnCount(20);
		
		// Put the text field on the pane
		//pane.getChildren().add(txt);

		// Hook up the event handler that defines 
		// what to do when the button is clicked.
		// See PrimeTesterEventHandler.java
		isPrime.setOnAction(new PrimeTesterEventHandler(enterPrime, result));

		// Use pane as the root of the scene
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		
		// Set the title of the window
		stage.setTitle("Prime Tester");
		
		// Show the window
		stage.show();	
	}
}
