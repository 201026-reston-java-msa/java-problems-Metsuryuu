package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Driver {

	public static void main(String[] args) {
		/*
		 *  this is where you're going to test the JUnit stuff in Evalservtest.
		 *  Copy and paste the method in this class and then test it in
		 *  the main. Ensure the method is static.
		 *  
		 *  This is solely for practical testing, it needs to be in the proper file
		 *  (the other one) to actually pass the testing process.
		 *  
		 *  JUnit tests the output, it does not display it. Therefore, this
		 *  exists for ease of testing. You can delete it after.
		 */
		
		String s = "school";
		System.out.println(toPigLatin(s));
		
		int[] n = {1};
//		System.out.println(getScrabbleScore(s));

		
		
	}
	
	static public String toPigLatin(String string) {
		String[] words = string.split(" ");
		string = "";
		
		for(String word : words) {
			//this could also be implemented via a switch as opposed to if-else
			if(word.matches("^[aeiouAEIOU].+")) {	//if the first letter is a vowel.
				word = word+"ay";	//add 'ay' to the end.
			}else if(word.matches("^ch[a-z].+|th[a-z].+|qu[a-z].+")) {	//more sounds possible, kept short for proof of concept.
				word = word.substring(2,word.length())+ word.substring(0,2)+"ay";	//add the beginning to the end and add 'ay'.
			}else if(word.matches("^sch[a-z].+")) {
				word = word.substring(3,word.length())+ word.substring(0,3)+"ay";
			}else {
				word = word.substring(1,word.length())+word.substring(0,1)+"ay";
			}
			
			string += word + " ";	//add the fixed word to the string.
		}
		
		System.out.println(string+"hi");
		
		string.trim();	//get rid of any ending whitespace.
		
		return string;
	}
}
