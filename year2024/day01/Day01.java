import java.io.*;
import java.util.*;

public class Day01 {
	public static void PartOne() throws FileNotFoundException {
		//Boiler plate for reading the text file
		File in = new File("inputFiles\\day01.txt");
        	Scanner read = new Scanner(in);
        
	        //Var list
	        ArrayList<Integer> listOne = new ArrayList<>();
	        ArrayList<Integer> listTwo = new ArrayList<>();
	        int result = 0;
        
	        //Puts the left column into listOne and the right column into listTwo
	        while(read.hasNext()) {
	        	listOne.add(read.nextInt());
	        	listTwo.add(read.nextInt());
	        }
	        
	        //Useful Comment
	        listOne.sort(null);
	        listTwo.sort(null);
	        
	        //Declare out of loop to save on memory calls or something idk
	        int numOne;
	        int numTwo;
	        
	        //For each pair, bigger - smaller
	        for(int i = 0; i < listOne.size(); i++) {
	        	numOne = listOne.get(i);
	        	numTwo = listTwo.get(i);
	        	result += numOne > numTwo ? numOne - numTwo : numTwo - numOne;
	        }
	        
	        //2378066
	        System.out.println("Day 01 Part 1 Result: " + result);
	        read.close();
	}
	
	public static void PartTwo() throws FileNotFoundException {
		//Boiler plate for reading the text file
		File in = new File("inputFiles\\day01.txt");
	        Scanner read = new Scanner(in);
	        
	        //Var list
	        ArrayList<Integer> list = new ArrayList<>();
	        HashMap<Integer, Integer> map = new HashMap<>();
	        int result = 0;
	        int mapTemp;
	        
	        //Puts left column into a list, and
	        //counts how many times (value) a number (key) is in the right column
	        while(read.hasNext()) {
	        	list.add(read.nextInt());
	        	mapTemp = read.nextInt();
	        	map.putIfAbsent(mapTemp, 0);
	        	map.replace(mapTemp, map.get(mapTemp) + 1 );
	        }
	        
	        //num * amount of num
	        for(Integer num : list) {
	        	result += num * map.getOrDefault(num, 0);
	        }
	        
	        //18934359
	        System.out.println("Day 01 Part 2 Result: " + result);
	        read.close();
	}
}
