package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class d2p2 {
	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\AdventOfYourMother2023\\src\\day2\\d2in.txt");
        Scanner read = new Scanner(in);
        int ret = 0;
        
        while(read.hasNext()) {
        	String[] game = read.nextLine().split("[:;]");
        	int minRed = Integer.MIN_VALUE;
            int minGreen = Integer.MIN_VALUE;
            int minBlue = Integer.MIN_VALUE;
        	boolean isPossible = true;
        	
        	for(int i = 1; i < game.length; i++) {
        		String[] rolls = game[i].split(",");
        		for(String s : rolls) {
        			if(s.split(" ")[2].equals("blue") && Integer.parseInt(s.split(" ")[1]) > minBlue) {
        				minBlue = Integer.parseInt(s.split(" ")[1]);
        			}
        			else if(s.split(" ")[2].equals("green") && Integer.parseInt(s.split(" ")[1]) > minGreen) {
        				minGreen = Integer.parseInt(s.split(" ")[1]);
        			}
        			else if(s.split(" ")[2].equals("red") && Integer.parseInt(s.split(" ")[1]) > minRed) {
        				minRed = Integer.parseInt(s.split(" ")[1]);
        			}
        		}
        	}
        	if(isPossible) {
    			ret += minBlue * minGreen * minRed;
    		}
        }
        System.out.println(ret);
	}
}
