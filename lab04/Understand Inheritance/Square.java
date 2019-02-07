package ca.utoronto.utm.lab04;

public class Square extends Rectangle{
	public Square() {
		this("blue", 10, 100, 100);
	}
	
	public Square(String color, int width, int x, int y) {
		super(color, width, width, x, y);
	}
}