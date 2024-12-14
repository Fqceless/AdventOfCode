import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day07 {
	public static void PartOne() throws FileNotFoundException {
		//Boiler plate for reading the text file
		File in = new File("inputFiles\\day07.txt");
        Scanner read = new Scanner(in);
        
        long result = 0;
        long sum = 0;
        long target;
        
        while(read.hasNextLine()) {
        	ArrayList<Long> nums = new ArrayList<>(); 
        	ArrayList<String> ops = new ArrayList<>();
        	String line = read.nextLine();
        	for(String s : line.split("[ :]")) {
        		if(!"".equals(s)) {
            		nums.add(Long.parseLong(s));
        		}
        	}
        	
        	target = nums.get(0);
        	for(int i = 1; i < nums.size() - 1; i++) {
        		ops.add("+");
        	}
        	
        	for(int p = 0; p < Math.pow(2, ops.size()); p++) {
        		sum = nums.get(1);
        		for(int i = 1; i < nums.size() - 1; i++) {
            		if("+".equals(ops.get(i - 1))){
            			sum += nums.get(i + 1);
            		}
            		else {
            			sum *= nums.get(i + 1);
            		}
            	}
        		if(sum == target) {
        			result += target;
        			break;
        		}
        		else {
        			biFlipOps(ops);
        		}
        	}
        }
        
        //850435817339
        System.out.println("Day 07 Part 1 Result: " + result);
        read.close();
	}
	
	public static void PartTwo() throws FileNotFoundException {
		//Boiler plate for reading the text file
		File in = new File("inputFiles\\day07.txt");
        Scanner read = new Scanner(in);
        
        long result = 0;
        long sum = 0;
        long target;
        
        while(read.hasNextLine()) {
        	ArrayList<Long> nums = new ArrayList<>(); 
        	ArrayList<String> ops = new ArrayList<>();
        	String line = read.nextLine();
        	for(String s : line.split("[ :]")) {
        		if(!"".equals(s)) {
            		nums.add(Long.parseLong(s));
        		}
        	}
        	
        	target = nums.get(0);
        	for(int i = 1; i < nums.size() - 1; i++) {
        		ops.add("+");
        	}
        	
        	for(int p = 0; p < Math.pow(3, ops.size()); p++) {
        		sum = nums.get(1);
        		for(int i = 1; i < nums.size() - 1; i++) {
            		if("+".equals(ops.get(i - 1))){
            			sum += nums.get(i + 1);
            		}
            		else if("*".equals(ops.get(i - 1))){
            			sum *= nums.get(i + 1);
            		}
            		else {
            			sum = Long.parseLong(String.valueOf(sum) + String.valueOf(nums.get(i + 1)));
            		}
            	}
        		if(sum == target) {
        			result += target;
        			break;
        		}
        		else {
        			triFlipOps(ops);
        		}
        	}
        }
        
        //850435817339
        System.out.println("Day 07 Part 2 Result: " + result);
        read.close();
	}
	
	private static ArrayList<String> biFlipOps(ArrayList<String> ops){
		String prev = "";
		for(int i = ops.size() - 1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				prev += ops.get(j);
			}
			if(!prev.contains("+")) {
				ops.set(i, biFlipOp(ops.get(i)));
			}
			prev = "";
		}
		
		return ops;
	}
	
	private static String biFlipOp(String op) {
		return "+".equals(op) ? "*" : "+";
	}
	
	private static ArrayList<String> triFlipOps(ArrayList<String> ops){
		String prev = "";
		for(int i = ops.size() - 1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				prev += ops.get(j);
			}
			if(!prev.contains("+") && !prev.contains("*")) {
				ops.set(i, triFlipOp(ops.get(i)));
			}
			prev = "";
		}
		
		return ops;
	}
	
	private static String triFlipOp(String op) {
		if("+".equals(op)) {
			return "*";
		}
		else if("*".equals(op)) {
			return "||";
		}
		else {
			return "+";
		}
	}
}
