package edu.grinnell.csc207.youtztim.utils;

import java.math.*;

public class Calculator {
	
	public static BigInteger eval0(String expression){

		int total, math;
		total = 0;
		int i = 0;
		String block;
		
		while(i<expression.length()){
			block = expression.substring(i, expression.indexOf(' ', i+1));
			if (block == "+"){
				i = i + 2;
				block = expression.substring(i, expression.indexOf(' ', i+1));
				total = total + (math = Integer.parseInt(block));
				i = i + block.length();
			}
			if (block == "-"){
				i = i + 2;
				block = expression.substring(i, expression.indexOf(' ', i+1));
				total = total - (math = Integer.parseInt(block));
				i = i + block.length();
			}
			if (block == "*"){
				i = i + 2;
				block = expression.substring(i, expression.indexOf(' ', i+1));
				total = total * (math = Integer.parseInt(block));
				i = i + block.length();
			}
			if (block == "/"){
				i = i + 2;
				block = expression.substring(i, expression.indexOf(' ', i+1));
				total = total / (math = Integer.parseInt(block));
				i = i + block.length();
			}
			if (block == "^"){
				i = i + 2;
				block = expression.substring(i, expression.indexOf(' ', i+1));
				total = total ^ (math = Integer.parseInt(block));
				i = i + block.length();
			}
			else total = Integer.parseInt(block);
		}

		return BigInteger.valueOf(total);
		}
}
		

