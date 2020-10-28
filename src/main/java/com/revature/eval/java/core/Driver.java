package com.revature.eval.java.core;

import java.util.HashMap;
import java.util.Map;

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
		
		String s = "olly olly in come free";
		System.out.println(wordCount(s));
		
	}
	
	static public Map<String, Integer> wordCount(String string) {
		String[] words = string.split("[- +\\,]+");	//TODO this will need to be refined.
		Map<String, Integer> count = new HashMap<>();
		
		for(String word : words) {
			count.compute(word, (k,v) -> v == null ? 1 : ++v);
		}
		return count;
	}
}
