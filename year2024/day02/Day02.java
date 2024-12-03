import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day02 {
	public static void PartOne() throws FileNotFoundException {
		//Boiler plate for reading the text file
		File in = new File("inputFiles\\day02.txt");
        Scanner read = new Scanner(in);
        
        //Var decl
        int currNum;
        int nextNum;
        int difference;
        boolean isIncreasing;
        int result = 0;
        
        while(read.hasNextLine()) {
        	//easily separate each line into all the numbers
        	String[] report = read.nextLine().split(" ");
        	
        	//checks for increasing vs decreasing and re-inits skip
        	currNum = Integer.parseInt(report[0]);
        	nextNum = Integer.parseInt(report[1]);
        	isIncreasing = currNum < nextNum;
            boolean skip = false;
        	
            //if a fail happens, abort the whole for loop
        	for(int i = 0; i < report.length - 1 && !skip; i++) {
        		currNum = Integer.parseInt(report[i]);
            	nextNum = Integer.parseInt(report[i + 1]);
        		difference = isIncreasing ? nextNum - currNum : currNum - nextNum;
        		if(difference < 1 || difference > 3) {
        			skip = true;
        		}
        	}
        	result += skip ? 0 : 1;
        }
        
        //585
        System.out.println("Day 02 Part 1 Result: " + result);
        read.close();
	}
	
	public static void PartTwo() throws FileNotFoundException {
		//Boiler plate for reading the text file
				File in = new File("inputFiles\\day02.txt");
		        Scanner read = new Scanner(in);
		        
		        //var decl
		        int currNum;
		        int nextNum;
		        int difference;
		        boolean isIncreasing;
		        int result = 0;
		        
		        while(read.hasNextLine()) {
		        	String[] report = read.nextLine().split(" ");
		        	
		        	currNum = Integer.parseInt(report[0]);
		        	nextNum = Integer.parseInt(report[1]);
		        	isIncreasing = currNum < nextNum;
		        	//poker joke
		        	boolean oneTime = false;
		            boolean skip = false;
		        	
		            //now there is a oneTime buffer before we init skip
		        	for(int i = 0; i < report.length - 1 && !skip; i++) {
		        		currNum = Integer.parseInt(report[i]);
		            	nextNum = Integer.parseInt(report[i + 1]);
		        		difference = isIncreasing ? nextNum - currNum : currNum - nextNum;
		        		if(difference < 1 || difference > 3) {
		        			if(oneTime) {
		        				skip = true;
		        			}
		        			else {
		        				oneTime = true;
		        			}
		        		}
		        	}
		        	result += skip ? 0 : 1;
		        }
		        
		        //626
		        System.out.println("Day 02 Part 1 Result: " + result);
		        read.close();
	}
}
