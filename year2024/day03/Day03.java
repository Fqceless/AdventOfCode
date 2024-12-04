import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day03 {
	public static void PartOne() throws FileNotFoundException {
		//Boiler plate for reading the text file
		File in = new File("inputFiles\\day03.txt");
        Scanner read = new Scanner(in);
        
        //Var decl
        String match = "";
        String[] nums;
        int numOne;
        int numTwo;
        int result = 0;
        
        //Finds all instances of "mul([num],[num])"
        //and separates them into the two nums to multiply
        while(read.hasNext()) {
        	match = read.findInLine("mul\\(\\d*,\\d*\\)");
        	
        	if(match != null) {
        	
        		nums = match.split(",");
	        	numOne = Integer.parseInt(nums[0].substring(4));
	        	numTwo = Integer.parseInt(nums[1].substring(0, nums[1].length() - 1));
        		
            	result += numOne * numTwo;
        	}
        	//need this to make sure the dumb scanner doesn't just give up at the end of the line
        	else {
        		read.nextLine();
        	}
        }
        
        //181345830
        System.out.println("Day 03 Part 1 Result: " + result);
        read.close();
	}
	
	public static void PartTwo() throws FileNotFoundException {
		//Boiler plate for reading the text file
		File in = new File("inputFiles\\day03.txt");
        Scanner read = new Scanner(in);
        
        //Var decl
        String match = "";
        String[] nums;
        int numOne;
        int numTwo;
        boolean doMul = true;
        int result = 0;
        
        //Finds all instances of "mul([num],[num])", "do()", and "don't()"
        //and correctly assigns the doMul boolean
        //and if doMul == true, it separates them into the two nums to multiply
        while(read.hasNext()) {
        	match = read.findInLine("mul\\(\\d*,\\d*\\)|do\\(\\)|don't\\(\\)");
        	
        	if("do()".equals(match)) {
        		doMul = true;
        	}
        	else if("don't()".equals(match)){
        		doMul = false;
        	}
        	else if(match != null && doMul) {
        		nums = match.split(",");
	        	numOne = Integer.parseInt(nums[0].substring(4));
	        	numTwo = Integer.parseInt(nums[1].substring(0, nums[1].length() - 1));
        		
            	result += numOne * numTwo;
        	}
        	//it really shouldn't need this line but it does
        	//lmk if there is a better way
        	else if(match == null){
        		read.nextLine();
        	}
        }
        
        //98729041
        System.out.println("Day 03 Part 2 Result: " + result);
        read.close();
	}
}
