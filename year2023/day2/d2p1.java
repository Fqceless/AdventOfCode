package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class d2p1 {
	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\AdventOfYourMother2023\\src\\day2\\d2in.txt");
        Scanner read = new Scanner(in);
        final int MAX_RED = 12;
        final int MAX_GREEN = 13;
        final int MAX_BLUE = 14;
        int ret = 0;
        boolean isPossible = true;
        
        while(read.hasNext()) {
        	String[] game = read.nextLine().split("[:;]");
        	isPossible = true;
        	
        	for(int i = 1; i < game.length; i++) {
        		String[] rolls = game[i].split(",");
        		for(String s : rolls) {
        			if(s.split(" ")[2].equals("blue") && Integer.parseInt(s.split(" ")[1]) > MAX_BLUE) {
        				isPossible = false;
        			}
        			else if(s.split(" ")[2].equals("green") && Integer.parseInt(s.split(" ")[1]) > MAX_GREEN) {
        				isPossible = false;
        			}
        			else if(s.split(" ")[2].equals("red") && Integer.parseInt(s.split(" ")[1]) > MAX_RED) {
        				isPossible = false;
        			}
        		}
        	}
        	if(isPossible) {
    			ret += Integer.parseInt(game[0].split(" ")[1]);
    		}
        }
        System.out.println(ret);
	}
}
