package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class d4p1 {
	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\AdventOfYourMother2023\\src\\day4\\d4in.txt");
        Scanner read = new Scanner(in);
        int ret = 0;
        
        while(read.hasNext()) {
        	String[] game = read.nextLine().split("[:|]");
        	String[] winningNums = game[1].split(" ");
        	String[] yourNums = game[2].split(" ");
        	int numMatches = 0;
        	
        	ArrayList<Integer> winningNumsList = new ArrayList<>();
        	ArrayList<Integer> yourNumsList = new ArrayList<>();
        	
        	for(String s : winningNums) {
        		if(!s.equals("")) {
        			winningNumsList.add(Integer.parseInt(s));
        		}
        	}
        	for(String s : yourNums) {
        		if(!s.equals("")) {
        			yourNumsList.add(Integer.parseInt(s));
        		}
        	}
        	
        	for(int num : winningNumsList) {
        		if(yourNumsList.contains(num)) {
        			numMatches++;
        		}
        	}
        	
        	if(numMatches > 0) {
        		ret += Math.pow(2, numMatches - 1);
        	}
        }
        System.out.println(ret);
	}
}
