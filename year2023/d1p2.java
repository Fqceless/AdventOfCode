package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class d1p2 {
	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\AdventOfYourMother2023\\src\\day1\\d1in.txt");
        Scanner read = new Scanner(in);
        int sum = 0;
        while(read.hasNext()) {
        	String num = "";
        	String input = read.nextLine();
        	
        	num += findWordNumForward(input);
        	
        	num += findWordNumBackward(input);
        	
        	System.out.println(num);
        	sum += Integer.parseInt(num);
        }
        System.out.println(sum);
	}
	
	private static int findWordNumForward(String s) {
		String ps = "";
		for(char c : s.toCharArray()) {
			ps += c;
    		if(Character.isDigit(c)){
    			return Character.getNumericValue(c);
    		}
    		else if(ps.contains("one")) {
    			return 1;
    		}
    		else if(ps.contains("two")) {
    			return 2;
    		}
    		else if(ps.contains("three")) {
    			return 3;
    		}
    		else if(ps.contains("four")) {
    			return 4;
    		}
    		else if(ps.contains("five")) {
    			return 5;
    		}
    		else if(ps.contains("six")) {
    			return 6;
    		}
    		else if(ps.contains("seven")) {
    			return 7;
    		}
    		else if(ps.contains("eight")) {
    			return 8;
    		}
    		else if(ps.contains("nine")) {
    			return 9;
    		}
    	}
		return -9999999;
	}
	
	private static int findWordNumBackward(String s) {
		String rs = "";
		for (int i = s.length()-1; i >= 0; i--) {
			rs += s.charAt(i);
		}
		String ps = "";
		for(char c : rs.toCharArray()) {
			ps = c + ps;
    		if(Character.isDigit(c)){
    			return Character.getNumericValue(c);
    		}
    		else if(ps.contains("one")) {
    			return 1;
    		}
    		else if(ps.contains("two")) {
    			return 2;
    		}
    		else if(ps.contains("three")) {
    			return 3;
    		}
    		else if(ps.contains("four")) {
    			return 4;
    		}
    		else if(ps.contains("five")) {
    			return 5;
    		}
    		else if(ps.contains("six")) {
    			return 6;
    		}
    		else if(ps.contains("seven")) {
    			return 7;
    		}
    		else if(ps.contains("eight")) {
    			return 8;
    		}
    		else if(ps.contains("nine")) {
    			return 9;
    		}
    	}
		return -999999999;
	}
}
