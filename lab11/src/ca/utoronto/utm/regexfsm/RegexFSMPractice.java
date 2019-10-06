package ca.utoronto.utm.regexfsm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFSMPractice {
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		try {
			while ((line = in.readLine()) != null) {
				if (recognizeSomethingRegex(line)) {
					System.out.println("recognizeSomethingRegex accepts " + line);
				} else {
					System.out.println("recognizeSomethingRegex rejects " + line);
				}
				if (recognizeSomethingFSM(line)) {
					System.out.println("recognizeSomethingFSM accepts " + line);
				} else {
					System.out.println("recognizeSomethingFSM rejects " + line);
				}
				if (recognizeWellFedRegex(line)) {
					System.out.println("recognizeWellFedRegex accepts " + line);
				} else {
					System.out.println("recognizeWellFedRegex rejects " + line);
				}
				if (recognizeWellFedFSM(line)) {
					System.out.println("recognizeWellFedFSM accepts " + line);
				} else {
					System.out.println("recognizeWellFedFSM rejects " + line);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Come up with some strings so that recognizeSomethingRegex returns true
	 * 
	 * 3aei:x...end
	 * 232938298392832aei:x...end
	 * 2322aaa:xyz.end
	 * 1ioo:yyy.blah..end
	 * 1ioo:yyyend
	 * 
	 * Describe what this recognizes.
	 * 
	 * recognizeSomethingRegex(String s) will recognize a string s from a language with the following properties:
	 * The string s begins with one or more digit between 0-9, followed by any 3 vowels in aeiou (repeated vowels
	 * are fine). This is followed by a colon after which we have either an x, y, or z. This is followed by any amount
	 * of non-line ending characters followed by 'end'
	 * 
	 */
	
	public static boolean recognizeSomethingRegex(String s) {
		// Implemented as FSM
		
		char [] c=s.toCharArray();
		int len=s.length();
		String specials = "aeiou:xyz";
		
		boolean retVal=true; 
		
		int n=0;
		int state=0; // Start out in the initial state
		while(n<len){
			switch(state){	
				case 0:
					if (('0'<=c[n] && c[n]<='9'))
						state = 2;
					else
						state = 1;
					break;
				case 1: // this is the trapped state
					break;
				case 2: // we need a vowel to move on 
					if (specials.indexOf(c[n]) >= 0)
						state = 3;
					else
						state = 1;
					break;
				case 3: // we need a vowel to move on
					if (specials.indexOf(c[n]) >= 0)
						state = 4;
					else
						state = 1;
					break;
				case 4: // we need a vowel to move on
					if (specials.indexOf(c[n]) >= 0)
						state = 5;
					else
						state = 1;
					break;
				case 5: 
					if (specials.indexOf(c[n]) >= 0)
						state = 6;
					else
						state = 1;
					break;
				case 6: // we need an x y or z
					if (specials.indexOf(c[n]) >= 0)
						state = 7;
					else
						state = 1;
					break;
				case 7: // now we can be anything except the non-line character
					if(c[len-3] == 'e' && c[len-2] == 'n' && c[len-1] == 'd' && len-n == 1) 
						state = 8;
					else if(len-n == 1) 
						state = 1;
					else 
						state = 7;
					break;
				case 8:
					break;
			}
			n=n+1;
		}
		if (state != 8)
			retVal=false;
		
		return retVal;
	}
	/**
	 * Come up with some strings so that recognizeSomethingFSM returns true
	 * 
	 * 343242342340
	 * 20
	 * 1000010
	 * 11231231231230000000
	 * 0000
	 * 
	 * Describe what this recognizes.
	 * This FSM accepts any string that ends in 0 and consists of only positive numbers.
	 * The corresponding regular expression would be: "^(\d)*0$" 
	 * 
	 */
	public static boolean recognizeSomethingFSM(String s) {
		// Implemented as regex
		Pattern p = Pattern.compile("^(\\d)*0$");
		Matcher m = p.matcher(s);
		return m.matches();
	}

	/**
	 * 
	 * A well-fed number is an integer in which 7s appear but 9s do not. (Why? Because seven eight nine.) 
	 * This means the number can be made up of any digits EXCEPT 9, and must include AT LEAST ONE 7.
	 * This recognizer uses a regular expression to determine if the string given is a well-fed number.
	 * 
	 * @param s
	 * @return whether s is the string representation of a well-fed number
	 */
	public static boolean recognizeWellFedRegex(String s) {
		
		// COMPLETE THIS METHOD
		
		Pattern p = Pattern.compile("^[0-8]*7[0-8]*$");
		Matcher m = p.matcher(s);
		return m.matches();
	}

	/**
	 * This recognizer uses a Finite State Machine to determine whether s
	 * represents a well-fed number (as defined above)
	 * 
	 * @param s
	 * @return whether s is the string representation of a well-fed number
	 */
	public static boolean recognizeWellFedFSM(String s) {
		// COMPLETE THIS METHOD
		
		char [] c=s.toCharArray();
		int len=s.length();
		
		boolean retVal=true;
		
		int n=0;
		int state=0; // Start out in the initial state
		while(n<len){
			switch(state){	
				case 0:
					if (('0'<=c[n] && c[n]<='6') || c[n] == '8')
						state = 0;
					else if (c[n] == '7')
						state = 1;
					else 
						state=2;
					break;
				case 1:
					if (('0'<=c[n] && c[n]<='8'))
						state = 1;
					else
						state = 2;
					break;
				case 2:
					break;
			}
			n=n+1;
		}
		if (state != 1)
			retVal=false;
		
		return retVal;
	}
}