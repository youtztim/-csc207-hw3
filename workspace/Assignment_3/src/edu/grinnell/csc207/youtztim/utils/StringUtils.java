package edu.grinnell.csc207.youtztim.utils;

import java.util.*;
import java.lang.String;

public class StringUtils {

	public static String[] splitAt(String word, char q) {
		int i, j;
		i = -1;
		j = 0;

//count the instances of the separator				
		int counter = 0;
		for (int k = 0; k < word.length(); k++) {
			if (word.charAt(k) == q) {
				counter++;
			}
		}

//use the counter value to initialize a correctly sized array
		String[] results = new String[counter + 1];

//Break down the string into chunks while handling first and last instance
		while (j < counter) {
			results[j] = word.substring(i + 1, word.indexOf(q, i + 1));
			i = word.indexOf(q, i + 1);
			j++;
		}
		results[j] = word.substring(i + 1, word.length());
		
		System.out.println(Arrays.toString(results));
		return results;

	}

	public static String[] splitCSV(String word) {
		int q = 0;
		ArrayList<String> results = new ArrayList<String>();
		
		for(int i = 0, j = 0; i < word.length(); i++) {
			if(word.charAt(i) == ',' && q % 2 == 0){
				results.add(word.substring(j,i));
				j=i+1;
			}
			
			if(word.charAt(i) == '"') {
				if (word.charAt(i+1) == '"') {
					i++;
				}
				else q++;
				}
			}
	    String[] stockArr = new String[results.size()];
	    stockArr = results.toArray(stockArr);
		return stockArr;
		} //stackoverflow.com was used for help with ArrayLists

	public static String deLeet(String leet) {
		char[] deleeted = new char[leet.length()];
		for (int k = 0, i = 0; k < leet.length(); k++, i++) {
			if (leet.charAt(k) == '+') {
				deleeted[i] = 't';
				i++;
			} else if (leet.charAt(k) == '3') {
				deleeted[i] = 'e';
			} else if (leet.charAt(k) == '1') {
				deleeted[i] = 'l';
			} else if (leet.charAt(k) == '@') {
				deleeted[i] = 'a';
			} else if (leet.charAt(k) == '0') {
				deleeted[i] = 'o';
			} else if (leet.charAt(k) == '|') {
				if (leet.charAt(k + 1) == '3') {
					deleeted[i] = 'b';
					k++;
				}
				if (leet.charAt(k + 1) == '\\') {
					if (leet.charAt(k + 2) == '|') {
						deleeted[i] = 'n';
						k = k + 2;
					}
				}
			} else
				deleeted[i] = leet.charAt(k);

		}
		String results = new String(deleeted);
		return results;
	}

	public static String nameGame(String name) {
		String B = "B";
		String F = "F";
		String M = "M";
		String ame, bname, fname, mname;
		char c2 = name.charAt(1);
		if (c2 != 'a' && c2 != 'e' && c2 != 'i' && c2 != 'o' && c2 != 'u'){
			ame = name.substring(2);
		}
		else ame = name.substring(1);
		
		bname = B.concat(ame);
		fname = F.concat(ame);
		mname = M.concat(ame);
		
		String poem = name;
		poem.concat("! " + name + ", " + name + "bo Birley" + bname + "Bonana fanna fo" + fname + "Fee fy mo" + mname + "," + name + " !");
		return poem;
	}
		
	public static int[] fewestCoins(int total){
		int[] results = new int[4];
		int value = total;
		int twos = 0;
		int sevens = 0;
		int elevens = 0;
		int fiftyfours = 0;
		
		while (value > 0){
			if (value % 7 != 0){
				value = value - 2;
				twos++;
			}
			else sevens = value/7;
		}
		
		while (twos >= 2 && sevens >= 1) {
			if (twos >= 6 && sevens >= 6){
				fiftyfours++;
				twos = twos - 6;
				sevens = sevens - 6;
			}
			else twos = twos - 2;
			sevens--;
			elevens++;
		}
		results[0] = twos;
		results[1] = sevens;
		results[2] = elevens;
		results[3] = fiftyfours;
		return results;
	}
	
	public static void main(String[] args) {
		splitAt("Apple:Pear:Buh-nuh-nuh:Strawbeerry", ':');
		System.out.println(deLeet("133+ Haxx0rs Pw|\\| N00|3s a11 day3"));
		System.out.println("b,b\"");
		System.out.println("a,\"b,b\"\"\",c");
		System.out.println(nameGame("Bob"));
		System.out.println(fewestCoins(55));
	}
}
