package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		
		String s = "Let's eat, Grandma!";
//		System.out.println(toPigLatin(s));
		
		int n = 10001;
		System.out.println(calculateNthPrime(n));
		
		
	}
	
	static public int calculateNthPrime(int i) {
		
		//Easiest will be to implement the Sieve of Eratosthenes.
		int max = 1000005;
		
		ArrayList<Integer> primes = new ArrayList<>();
		
		boolean isPrime[] = new boolean[max];
		
		for(int j = 0; j < max; j++) {
			isPrime[j] = true;
			//the index is equal to the value it represents, i.e. isPrime[2] would be 2.
			//The boolean value dictates whether or not it is prime.
		}
		
		//begin at 2, the first prime number.
		for(int x = 2; x * x < max; x++) {
			
			if(isPrime[x] == true) {
				
				//mark all multiples of the prime as non-prime, for obvious reasons.
				for(int y = x*x; y < max; y += x) {
					isPrime[y] = false;
				}
				
			}
			
		}
		
		for(int z = 2; z < max; z++) {
			//all remaining prime indexes will have a true value.
			if(isPrime[z] == true) {
				//add the index value.
				primes.add(z);
			}
		}
		
		
		return primes.get(i-1);
		//Euler's sieve can achieve linear time, Eratosthenes' can achieve logarithmic time
		//when properly implemented.
	}
}
