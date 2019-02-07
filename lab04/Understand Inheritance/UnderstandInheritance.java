package ca.utoronto.utm.lab04;
public class UnderstandInheritance {

	public static void main(String[] args) {
		// 6) Review class Square, understand what happens when we execute the following:
		// that is, which methods are called and when...
		
		System.out.println("Starting");
		// The line above will simply use the Object class to print Starting.
		Square s=new Square(); 
		// The line above calls the Square() constructor
		// which executes this("blue", 10, 100, 100); which calls
		// the Square(String c, int width, int x, int y) constructor
		// which executes super(c, width, width, x, y); which calls 
		// which calls the Rectangle(String c, int width, int height, int x, int y) constructor
		// which calls upon super(c, x, y), which then calls upon
		// the Shape(String c, int x, int y) constructor, which executes 
		// the setPosition(x, y) method and also setColor(c) method from Shape class
		System.out.println(s.toString());
		// The line above calls the toString method that is in the Square class, which is not there,
		// it will then check for it in the rectangle class and from there will call upon the
		// toString method from the shape class, and concatenate its result with the toString method
		// from the rectangle class
		s.setWidth(20);
		// The line above will check for setWidth(int, width) in Square, but since it is not there
		// The line above will call the setWidth(int, width) in rectangle with passed in value.
		s.setX(10);
		// The line above will first check for the .setx() method in the Square class, however,
		// it is not there and then will attempt to find in Rectangle class, and it is also not here.
		// Then will execute setX(int x) in shape with passed in value.
	}

}
