package ca.utoronto.utm.arraylist;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class OddTest {

	@Test
	public void testOdds() {
		// Add test cases here
		ArrayList<Integer> actual;
		ArrayList<Integer> expected = new ArrayList<Integer>();
		
		actual = Odd.odds(-25);
		assertEquals("odds(-25) should be empty", expected, actual);  
		
		actual = Odd.odds(-1);
		assertEquals("odds(-1) should be empty", expected, actual);  

		actual = Odd.odds(-5);
		assertEquals("evens(-5) should be empty", expected, actual);  

		actual = Odd.odds(0);
		assertEquals("odds(0) should be empty", expected, actual);  

		actual = Odd.odds(1);
		assertEquals("odds(1) should be empty", expected, actual);  

		actual = Odd.odds(2);
		expected.add(1);
		assertEquals("odds(2) smallest non-empty even set", expected, actual);  

		actual = Odd.odds(11);
		expected.add(3);
		expected.add(5);
		expected.add(7);
		expected.add(9);
		assertEquals("odds(11) more general n", expected, actual);  

		actual = Odd.odds(12);
		expected.add(11);
		assertEquals("odds(12) more general n", expected, actual);  
		
		// Just to see what happens when a test case fails...
		// The test case below is not correct!!
		//actual = Even.evens(20);
		//assertEquals("evens(12) more general n", expected, actual); 	
	}

}
