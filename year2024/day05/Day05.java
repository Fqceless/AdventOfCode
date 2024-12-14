import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day05 {
	public static void PartOne() throws FileNotFoundException {
		//Boiler plate for reading the text file
		File in = new File("inputFiles\\day05.txt");
        Scanner read = new Scanner(in);
        
        int result = 0;
        boolean[][] rules = new boolean[100][100];
        boolean updateValid = true;
        String line = "";
        
        
        for(int i = 0; i < 100; i++) {
        	for(int j = 0; j < 100; j++) {
        		rules[i][j] = false;
        	}
        }
        
        while(read.hasNextLine()) {
        	line = read.nextLine();
        	String[] nums;
        	
        	if(line.contains("|")) {
        		nums = line.split("\\|");
        		rules[Integer.parseInt(nums[0])][Integer.parseInt(nums[1])] = true; 
        	}
        	else if(line.contains(",")) {
        		nums = line.split(",");
        		updateValid = true;
        		for(int i = 1; i < nums.length && updateValid; i++) {
        			for(int j = 0; j < i && updateValid; j++) {
        				if(rules[Integer.parseInt(nums[i])][Integer.parseInt(nums[j])]) {
        					updateValid = false;
        				}
        			}
        		}
    			result += updateValid ? Integer.parseInt(nums[(nums.length / 2)]) : 0;
        	}
        }
        
        //4281
        System.out.println("Day 05 Part 1 Result: " + result);
        read.close();
	}
	
	public static void PartTwo() throws FileNotFoundException {
		//Boiler plate for reading the text file
		File in = new File("inputFiles\\day05.txt");
        Scanner read = new Scanner(in);
        
        int result = 0;
        boolean[][] rules = new boolean[100][100];
        boolean updateValid = true;
        String line = "";
        
        
        for(int i = 0; i < 100; i++) {
        	for(int j = 0; j < 100; j++) {
        		rules[i][j] = false;
        	}
        }
        
        while(read.hasNextLine()) {
        	line = read.nextLine();
        	String[] nums;
        	
        	if(line.contains("|")) {
        		nums = line.split("\\|");
        		rules[Integer.parseInt(nums[0])][Integer.parseInt(nums[1])] = true; 
        	}
        	else if(line.contains(",")) {
        		nums = line.split(",");
        		updateValid = true;
        		for(int i = 1; i < nums.length; i++) {
        			for(int j = 0; j < i; j++) {
        				if(rules[Integer.parseInt(nums[i])][Integer.parseInt(nums[j])]) {
        					updateValid = false;
        					int temp = Integer.parseInt(nums[i]);
        					nums[i] = nums[j];
        					nums[j] = String.valueOf(temp);
        					j = 0;
        				}
        			}
        		}
    			result += updateValid ? 0 : Integer.parseInt(nums[(nums.length / 2)]);
        	}
        }
        
        //5466
        System.out.println("Day 05 Part 2 Result: " + result);
        read.close();
	}
}
