package day1;

import java.io.*;
import java.util.Scanner;

public class d1p1 {
	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\AdventOfYourMother2023\\src\\day1\\d1in.txt");
        Scanner read = new Scanner(in);
        int sum = 0;
        while(read.hasNext()) {
        	String num = "";
        	String input = read.nextLine();
        	for(int i = 0; i < input.length(); i++) {
        		if(Character.isDigit(input.charAt(i))){
        			num += input.charAt(i);
        			break;
        		}
        	}
        	
        	for(int i = input.length() - 1; i >= 0; i--) {
        		if(Character.isDigit(input.charAt(i))){
        			num += input.charAt(i);
        			break;
        		}
        	}
        	sum += Integer.parseInt(num);
        }
        System.out.println(sum);
	}
}
