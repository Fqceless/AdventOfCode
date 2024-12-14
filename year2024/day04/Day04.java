import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day04 {
	public static void PartOne() throws FileNotFoundException {
		//Boiler plate for reading the text file
		File in = new File("inputFiles\\day04.txt");
	        Scanner read = new Scanner(in);
	        
	        //Var decl
	        HashMap<String, Character> map = new HashMap<>();
	        String line = "";
	        int currRow = 0;
	        int currColumn;
	        int result = 0;
	        
	        while(read.hasNext()) {
	        	line = read.next();
	        	currColumn = 0;
	        	for(Character c : line.toCharArray()) {
	        		map.put(pntToStr(currRow, currColumn), c);
	        		currColumn++;
	        	}
	        	currRow++;
	        }
	        
	        for(currRow = 0; currRow < 140; currRow++) {
	        	for(currColumn = 0; currColumn < 140; currColumn++) {
	        		result += checkForXmas(currRow, currColumn, map);
	        	}
	        }
	        
	        //2507
	        System.out.println("Day 04 Part 1 Result: " + result);
	        read.close();
	}

	public static void PartTwo() throws FileNotFoundException {
		//Boiler plate for reading the text file
		File in = new File("inputFiles\\day04.txt");
		Scanner read = new Scanner(in);
		
		//Var decl
		HashMap<String, Character> map = new HashMap<>();
		String line = "";
		int currRow = 0;
		int currColumn;
		int result = 0;
		
		while(read.hasNext()) {
			line = read.next();
			currColumn = 0;
			for(Character c : line.toCharArray()) {
				map.put(pntToStr(currRow, currColumn), c);
				currColumn++;
			}
			currRow++;
		}
		
		for(currRow = 1; currRow < 139; currRow++) {
			for(currColumn = 1; currColumn < 139; currColumn++) {
				result += checkForXedMas(currRow, currColumn, map);
			}
		}
		
		//1969
		System.out.println("Day 04 Part 2 Result: " + result);
		read.close();
	}

	private static String pntToStr(int x, int y) {
		return String.valueOf(x) + "," + String.valueOf(y);
	}
	
	private static int checkForXmas(int row, int col, HashMap<String, Character> map) {
		int result = 0;
		if(map.get(pntToStr(row, col)) == 'X') {
			//Checks up
			if(map.get(pntToStr(row + 1, col)) != null
					&& map.get(pntToStr(row + 1, col)) == 'M'
					&& map.get(pntToStr(row + 2, col)) != null
					&& map.get(pntToStr(row + 2, col)) == 'A'
					&& map.get(pntToStr(row + 3, col)) != null
					&& map.get(pntToStr(row + 3, col)) == 'S'){
				result++;
			}
			//Checks up-right
			if(map.get(pntToStr(row + 1, col + 1)) != null
					&& map.get(pntToStr(row + 1, col + 1)) == 'M'
					&& map.get(pntToStr(row + 2, col + 2)) != null
					&& map.get(pntToStr(row + 2, col + 2)) == 'A'
					&& map.get(pntToStr(row + 3, col + 3)) != null
					&& map.get(pntToStr(row + 3, col + 3)) == 'S'){
				result++;
			}
			//Checks right
			if(map.get(pntToStr(row, col + 1)) != null
					&& map.get(pntToStr(row, col + 1)) == 'M'
					&& map.get(pntToStr(row, col + 2)) != null
					&& map.get(pntToStr(row, col + 2)) == 'A'
					&& map.get(pntToStr(row, col + 3)) != null
					&& map.get(pntToStr(row, col + 3)) == 'S'){
				result++;
			}
			//Checks down-right
			if(map.get(pntToStr(row - 1, col + 1)) != null
					&& map.get(pntToStr(row - 1, col + 1)) == 'M'
					&& map.get(pntToStr(row - 2, col + 2)) != null
					&& map.get(pntToStr(row - 2, col + 2)) == 'A'
					&& map.get(pntToStr(row - 3, col + 3)) != null
					&& map.get(pntToStr(row - 3, col + 3)) == 'S'){
				result++;
			}
			//Checks down
			if(map.get(pntToStr(row - 1, col)) != null
					&& map.get(pntToStr(row - 1, col)) == 'M'
					&& map.get(pntToStr(row - 2, col)) != null
					&& map.get(pntToStr(row - 2, col)) == 'A'
					&& map.get(pntToStr(row - 3, col)) != null
					&& map.get(pntToStr(row - 3, col)) == 'S'){
				result++;
			}
			//Checks down-left
			if(map.get(pntToStr(row - 1, col - 1)) != null
					&& map.get(pntToStr(row - 1, col - 1)) == 'M'
					&& map.get(pntToStr(row - 2, col - 2)) != null
					&& map.get(pntToStr(row - 2, col - 2)) == 'A'
					&& map.get(pntToStr(row - 3, col - 3)) != null
					&& map.get(pntToStr(row - 3, col - 3)) == 'S'){
				result++;
			}
			//Checks left
			if(map.get(pntToStr(row, col - 1)) != null
					&& map.get(pntToStr(row, col - 1)) == 'M'
					&& map.get(pntToStr(row, col - 2)) != null
					&& map.get(pntToStr(row, col - 2)) == 'A'
					&& map.get(pntToStr(row, col - 3)) != null
					&& map.get(pntToStr(row, col - 3)) == 'S'){
				result++;
			}
			//Checks up-left
			if(map.get(pntToStr(row + 1, col - 1)) != null
					&& map.get(pntToStr(row + 1, col - 1)) == 'M'
					&& map.get(pntToStr(row + 2, col - 2)) != null
					&& map.get(pntToStr(row + 2, col - 2)) == 'A'
					&& map.get(pntToStr(row + 3, col - 3)) != null
					&& map.get(pntToStr(row + 3, col - 3)) == 'S'){
				result++;
			}
		}
		return result;
	}
	
	private static int checkForXedMas(int row, int col, HashMap<String, Character> map) {
		int result = 0;
		if(map.get(pntToStr(row, col)) == 'A') {
			/* Check for
			 * M S
			 *  A
			 * M S
			 */
			if(map.get(pntToStr(row + 1, col - 1)) == 'M'
					&& map.get(pntToStr(row - 1, col - 1)) == 'M'
					&& map.get(pntToStr(row + 1, col + 1)) == 'S'
					&& map.get(pntToStr(row - 1, col + 1)) == 'S'){
				result++;
			}
			/* Check for
			 * M M
			 *  A
			 * S S
			 */
			else if(map.get(pntToStr(row + 1, col - 1)) == 'M'
					&& map.get(pntToStr(row - 1, col - 1)) == 'S'
					&& map.get(pntToStr(row + 1, col + 1)) == 'M'
					&& map.get(pntToStr(row - 1, col + 1)) == 'S'){
				result++;
			}
			/* Check for
			 * S M
			 *  A
			 * S M
			 */
			else if(map.get(pntToStr(row + 1, col - 1)) == 'S'
					&& map.get(pntToStr(row - 1, col - 1)) == 'S'
					&& map.get(pntToStr(row + 1, col + 1)) == 'M'
					&& map.get(pntToStr(row - 1, col + 1)) == 'M'){
				result++;
			}
			/* Check for
			 * S S
			 *  A
			 * M M
			 */
			else if(map.get(pntToStr(row + 1, col - 1)) == 'S'
					&& map.get(pntToStr(row - 1, col - 1)) == 'M'
					&& map.get(pntToStr(row + 1, col + 1)) == 'S'
					&& map.get(pntToStr(row - 1, col + 1)) == 'M'){
				result++;
			}
		}
		
		return result;
	}

}
