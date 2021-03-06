package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] c = string.toCharArray();
		string = "";	//reset the string to avoid creating a new variable.
		
		for(int i = 0; i < c.length; i++) {
			string += c[c.length-i-1];	//counts in reverse order and place it in the string.
		}

		return string;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String[] hold = phrase.split("[ -]+");	//split based on whitespace and hyphens.	
		StringBuffer acronym = new StringBuffer();
		
		for(String s : hold) {
			acronym.append(s.substring(0,1).toUpperCase());	//capitalize the first letter and store it.
		}
		phrase = acronym.toString();	//put the acronym back in the string.
		
		return phrase;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if(this.sideOne == this.sideTwo && this.sideTwo == this.sideThree) {	//no need to compare all sides to each other
				return true;														//as equality was already proven by first arg
			}else {																	//and all sides must be equal.
				return false;
			}
			
		}

		public boolean isIsosceles() {
			if(this.sideOne == this.sideTwo || this.sideOne == this.sideThree || this.sideTwo == this.sideThree) {
				return true;
			}else {
				return false;
			}
		}

		public boolean isScalene() {
			if(this.sideOne != this.sideTwo && this.sideOne != this.sideThree && this.sideTwo != this.sideThree) {
				return true;
			}else {
				return false;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		
		char[] letters = string.toLowerCase().toCharArray();
		int score = 0;
		
		for(char letter : letters) {
			/*
			 * Based on the test cases, this is sufficient, an if() could be used to ensure
			 * that it is indeed an alphabet with Character.isAlphabetic().
			*/
			switch(letter) {
				case 'd':	//chain the cases together based on score.
				case 'g':	//d and g have the same score so case 'd' will pass to case 'g'.
					score += 2;
					break;	//add the respective score and move onto the next letter.
				case 'b':
				case 'c':
				case 'm':
				case 'p':
					score += 3;
					break;
				case 'f':
				case 'h':
				case 'v':
				case 'w':
				case 'y':
					score += 4;
					break;
				case 'k':
					score += 5;
					break;
				case 'j':
				case 'x':
					score += 8;
					break;
				case 'q':
				case 'z':
					score += 10;
					break;
				default:	//every other letter not explicitly mentioned.
					++score;	//only worth one point.
					break;
			}
		}
		
		return score;
		
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {	
		
		string = string.replaceAll("[)(]+", "");
		/*
		 * I had needed to replace all parentheses first as they would leave
		 * leading whitespace which would result in an error below.
		 */
		
		String[] clean = string.split("[^\\d+]+");	//remove any and all special characters in the sequence.
		StringBuffer finished = new StringBuffer();
		
		for(String s : clean){
			if(s.matches("^[0-9]+$")) {	//ensure only numerics are accepted.
				finished.append(s);
			}else{
				throw new IllegalArgumentException();	//if non-numeric, throw an exception.
			}
		}
		
		string = finished.toString();	//place the array back in the String.
		
		if(string.matches("[2-9]{1}+[0-9]{2}+[2-9]{1}+[0-9]{2}+[0-9]{4}")) {	//check to make sure there are only 10 numbers in the right order.
			return string;
		}else {
			throw new IllegalArgumentException();	//if not, throw an exception.
		}
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1 
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		
		string = string.replaceAll("\\n", "");
		
		String[] words = string.split("[- +\\,]+");	//TODO this will need to be refined, I believe.
		Map<String, Integer> count = new HashMap<>();
		
		for(String word : words) {
			//set the value to 1 for a new key, or add to the existing value.
			count.compute(word, (k,v) -> v == null ? 1 : ++v);
		}
		return count;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration (This question was dropped, but you can do it.)
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {	//TODO this has a problem with the final test, not sure why.
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
		
		string = string.trim();	//get rid of any ending whitespace.
		
		return string;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {

		String num = String.valueOf(input);
		char[] numbers = num.toCharArray();	//get the individual digits.
		input = 0;	//less variables, save memory, why not?
		
		for(char number : numbers) {
			//calculates the summation of the powers of the digits.
			input += Math.pow(Character.getNumericValue(number), numbers.length);
		}
		
		if(input == Integer.parseInt(num)) {	//if the summation is equal to the number, it is an Armstrong number.
			return true;	
		}else {
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> primes = new ArrayList<>();
		
		while(l % 2 == 0) {	//this alone will take care of all even numbers
			primes.add(2L);	//as all even numbers are divisible by 2.
			l /= 2;
		}
		
		for(int i = 3; i <= l/2; i += 2) {	//only need to test odd numbers (hence +=2 instead of ++).
			while(l % i == 0) {
				primes.add((long) i);
				l /= i;
			}
		}
		
		if(l > 2) {	//by this point, l should either be 2 or 1, otherwise, it was a prime.
			primes.add(l);
		}
				
		return primes;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			
			char[] tocipher = string.toCharArray();
			string = "";
			
			for(char letter : tocipher) {
				
				if(Character.isAlphabetic(letter)) {	//Ensure only alphabets are altered.
					
					if(Character.isUpperCase(letter)) { 
						
						/*
						 * The following calculations are based on ASCII mathematics 
						 * to create a modular field of the alphabet (mod 26) as opposed to 
						 * all ASCII characters.
						*/
						
						letter = (char)(((int)letter + key - 65) % 26 + 65); 
						
					}else {
						
						//same as above, but a field for lowercase alphabets.
						letter = (char)(((int)letter + key - 97) % 26 + 97);
						
					}
				}
				
				/*
				 * Put the completed cipher back in the string one character at a time. 
				 * This will be done for each char, including whitespace, numerics, 
				 * and special characters/punctuation. 
				*/
				
				string += letter;	
			}
			
			return string;
		}
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		
		if(i < 1) {
			throw new IllegalArgumentException();
		}
		
		//Easiest will be to implement the Sieve of Eratosthenes.
		int max = 1000005;	//I had looked this value up, Integer.MAX_VALUE was too large.
		
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
		
		//return the prime at the position requested.
		return primes.get(i-1);
		
		/*
		 * Euler's sieve can achieve linear time, Eratosthenes' can achieve 
		 * logarithmic time when properly implemented.
		 * Other sieves do exist, but are computationally inferior:
		 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
		*/
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			
			//remove all punctuation and make lowercase.
			string = string.replaceAll("\\p{Punct}", "").toLowerCase();
			
			char[] tocipher = string.toCharArray();
			string = "";
			int count = 0;
			
			for(char letter : tocipher) {
				
				if(Character.isAlphabetic(letter)) {	//Ensure only alphabets are altered.
					
					//effectively reverses the order of the alphabet, returning the proper cipher.
					letter = (char) ('a'+('z'-letter));
					
				}else if(Character.isWhitespace(letter)){
					//skip.
					continue;
				}	//everything else (digits) can be added directly.
				
				//keep a count to return ciphertext in blocks of five.
				if(count < 5) {
					string += letter;
					count++;
				}else {
					//at the sixth letter, add a space...
					string += " ";
					string += letter;
					count = 1;	//and reset the count.
				}
			}
			
			return string.trim();	//make sure no hanging whitespaces are returned.
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			
			char[] tocipher = string.toCharArray();
			string = "";
			
			for(char letter : tocipher) {
				
				if(Character.isAlphabetic(letter)) {
					
					//just reverse it to decode.
					letter = (char) ('z' + ('a'-letter));
				}else if(Character.isWhitespace(letter)) {
					//should still skip whitespace.
					continue;
				}
				
				string += letter;
			}
			
			return string;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {

		boolean valid = false;
		char[] numbers = string.toCharArray();
		int hold = 0;
		int position = 10;	//keep track of the position for calculation.
		
		for(char number : numbers) {
			if(Character.isDigit(number)) {
				
				//post-decrement operator used to cut down on lines.
				hold += Character.getNumericValue(number) * position--;
				
			}else if(number == 'X') {	//checks for X and treats it as 10.
				
				hold += 10 * position--;
				
			}else if(Character.isAlphabetic(number)) {	
				
				//any other character would infer an invalid ISBN immediately; no need to continue.
				return false;
				
			}
		}
		
		if(hold % 11 == 0) {
			valid = true;
		}
		
		return valid;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		
		char[] letters = string.toLowerCase().toCharArray();
		/*
		 * A boolean array could be used in tandem with an int index associated with
		 * the ASCII value of each alphabetical character...but a HashMap contains 
		 * both of those things and the ability to use the Character directly.
		 */
		Map<Character, Boolean> table = new HashMap<>();
		
		for (char ch = 'a'; ch <= 'z'; ++ch) {
			//load the HashMap will all alphabets.
			table.put(ch, false);
		}	  
		
		for(char letter : letters) {
			
			if(letter >= 'a' && letter <= 'z') {
				
				/*
				 * Lambda expression to make the value of each Character true
				 * if it existed in the string.
				 */
				table.compute(letter, (k,v) -> v == false ? true : true);	
			}
		}
		
		for(Map.Entry<Character, Boolean> entry : table.entrySet()) {
			if(!entry.getValue()) {
				//any letter which hasn't been explicitly mention will still be false.
				return false;
			}
		}
		
		//if it hasn't returned false, then it would be true.
		return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration (Dropped, try to complete it anyway)
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		
		int sum = 0;
		
		/*
		 * While there are two primary ways to solve this--checking each value
		 * in the set modulo i and adding them to sum, or utilizing the lcm,
		 * gcd, and the formula for all natural numbers up to n--Sets provide
		 * a much simpler solution due to duplicate removal.
		 */
		Set<Integer> multiples = new HashSet<>();
		
		for(int number : set) {
			
			/*
			 * Increase by the number to speed up the process while 
			 * ensuring only multiples will be added.
			 */
			for(int j = 0; j < i; j += number) {
				
				//add each number to the Set; duplicates will not be added.
				multiples.add(j);
				
			}
		}
		
		for(int n : multiples) {
			//finally, add everything to the sum.
			sum += n;
		}
		/*
		 * I had attempted to utilize the forEach() method in the Set interface
		 * with a lambda expression, however, variables are effectively final
		 * within lambdas.
		 */
		
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		
		//remove all spaces.
		string = string.replaceAll("\\s", "");
		int sum = 0;
				
		//check if string is too short or non-numeric before any calculations.
		if(string.length() <= 1 || !string.matches("[0-9]+")) {
				
			//early exit to reserve avoid wasting time and resources.
			return false;
					
		}
				
		List<Integer> numbers = new LinkedList<>();
				
		//load the list with all the numbers in the string.
		for(int i = string.length()-1; i >= 0; i--) {
			numbers.add(Character.getNumericValue(string.charAt(i)));
		}
				
		//complete the necessary Luhn calculations.
		for(int i = 1; i < numbers.size(); i += 2) {
					
			numbers.set(i, numbers.get(i)*2);

			if(numbers.get(i) > 9) {
				numbers.set(i, numbers.get(i)-9);
			}
				
		}
			
		for(int n : numbers) {
			sum += n;
		}
						
		if(sum % 10 == 0) {
			return true;
		}
				
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		
		Integer a = null;
		Integer b = null;
		
		String[] hold = string.split("[ ?]+");
		String s = "";
		
		for(String st : hold) {

			if(st.matches("[-0-9]+")) {	//if the string is a numeric (including negatives).
				
				if(a == null) {	//assign a first.
					a = Integer.parseInt(st);
				}else {	//assign b after.
					b = Integer.parseInt(st);
				}
				
				//get the operation from the question and set a flag.
			}else if(st.matches("plus")) {
				s = "p";
				
			}else if(st.matches("multiplied")) {
				s = "mu";
				
			}else if(st.matches("minus")) {
				s = "mi";
				
			}else if(st.matches("divided")) {
				s = "d";
			}
		}
		
		//use the flag in a switch and return the solution for the proper operation.
		switch(s){
			case "p":
				return a+b;
			case "mu":
				return a*b;
			case "mi":
				return a-b;
			case "d":
				return a/b;
		}
		
		return 0;

	}

}
