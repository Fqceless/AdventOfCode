import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day06 {
	public static void PartOne() throws FileNotFoundException {
		//Boiler plate for reading the text file
		File in = new File("inputFiles\\day06.txt");
	        Scanner read = new Scanner(in);
	        
	        //Var decl
	        HashMap<String, Character> map = new HashMap<>();
	        String line = "";
	        String start = "";
	        String direction = "UP";
	        int currRow = 0;
	        int currColumn;
	        int result = 0;
	        
	        while(read.hasNext()) {
	        	line = read.next();
	        	currColumn = 0;
	        	for(Character c : line.toCharArray()) {
	        		map.put(pntToStr(currRow, currColumn), c);
	        		if(c == '^') {
	        			start = pntToStr(currRow, currColumn);
	        		}
	        		currColumn++;
	        	}
	        	currRow++;
	        }
	        
	        currRow = Integer.parseInt(start.split(",")[0]);
	        currColumn = Integer.parseInt(start.split(",")[1]);
	        map.replace(pntToStr(currRow, currColumn), '.');
	        
	        while(map.containsKey(pntToStr(currRow, currColumn))) {
	        	if(map.get(pntToStr(currRow, currColumn)) == '.') {
	        		result++;
	            	map.replace(pntToStr(currRow, currColumn), 'X');
	        	}
	        	
	        	if("UP".equals(direction)) {
	        		if(map.containsKey(pntToStr(currRow - 1, currColumn))
	        				&& map.get(pntToStr(currRow - 1, currColumn)) == '#') {
	        			direction = "RIGHT";
	        		}
	        		else {
	        			currRow--;
	        		}
	        	}
	        	else if("RIGHT".equals(direction)) {
	        		if(map.containsKey(pntToStr(currRow, currColumn + 1))
	        				&& map.get(pntToStr(currRow, currColumn + 1)) == '#') {
	        			direction = "DOWN";
	        		}
	        		else {
	        			currColumn++;
	        		}
	        	}
	        	else if("DOWN".equals(direction)) {
	        		if(map.containsKey(pntToStr(currRow + 1, currColumn))
	        				&& map.get(pntToStr(currRow + 1, currColumn)) == '#') {
	        			direction = "LEFT";
	        		}
	        		else {
	        			currRow++;
	        		}
	        	}
	        	else if("LEFT".equals(direction)) {
	        		if(map.containsKey(pntToStr(currRow, currColumn - 1))
	        				&& map.get(pntToStr(currRow, currColumn - 1)) == '#') {
	        			direction = "UP";
	        		}
	        		else {
	        			currColumn--;
	        		}
	        	}
	        }
	        
	        //5067
	        System.out.println("Day 06 Part 1 Result: " + result);
	        read.close();
	}
	
	public static void PartTwo() throws FileNotFoundException {
		//Boiler plate for reading the text file
		File in = new File("inputFiles\\day06.txt");
	        Scanner read = new Scanner(in);
	        
	        //Var decl
	        HashMap<String, String> map = new HashMap<>();
	        String line = "";
	        String start = "";
	        String direction = "UP";
	        int currRow = 0;
	        int currColumn;
	        int result = 0;
	        
	        while(read.hasNext()) {
	        	line = read.next();
	        	currColumn = 0;
	        	for(Character c : line.toCharArray()) {
	        		map.put(pntToStr(currRow, currColumn), c.toString());
	        		if(c == '^') {
	        			start = pntToStr(currRow, currColumn);
	        		}
	        		currColumn++;
	        	}
	        	currRow++;
	        }
	        
	        currRow = Integer.parseInt(start.split(",")[0]);
	        currColumn = Integer.parseInt(start.split(",")[1]);
	        map.replace(pntToStr(currRow, currColumn), map.get(pntToStr(currRow, currColumn)) + "W");
	        
	        while(map.containsKey(pntToStr(currRow, currColumn))) {
	        	if("UP".equals(direction)) {
	        		if(map.containsKey(pntToStr(currRow - 1, currColumn))
	        				&& map.get(pntToStr(currRow - 1, currColumn)).equals("#")) {
	        			direction = "RIGHT";
	            		map.replace(pntToStr(currRow, currColumn), map.get(pntToStr(currRow, currColumn)) + "^");
	        		}
	        		else {
	            		map.replace(pntToStr(currRow, currColumn), map.get(pntToStr(currRow, currColumn)) + "^");
	        			if(map.containsKey(pntToStr(currRow - 1, currColumn))
	        					&& map.get(pntToStr(currRow - 1, currColumn)).equals(".") 
	        					&& parallelUniverse(map, currRow, currColumn, "RIGHT")) {
	        				map.replace(pntToStr(currRow - 1, currColumn), map.get(pntToStr(currRow - 1, currColumn)) + "W");
	        				result++;
	        			}
	        			currRow--;
	        		}
	        	}
	        	else if("RIGHT".equals(direction)) {
	        		if(map.containsKey(pntToStr(currRow, currColumn + 1))
	        				&& map.get(pntToStr(currRow, currColumn + 1)).contains("#")) {
	        			direction = "DOWN";
	            		map.replace(pntToStr(currRow, currColumn), map.get(pntToStr(currRow, currColumn)) + ">");
	        		}
	        		else {
	            		map.replace(pntToStr(currRow, currColumn), map.get(pntToStr(currRow, currColumn)) + ">");
	        			if(map.containsKey(pntToStr(currRow, currColumn + 1)) 
	        					&& map.get(pntToStr(currRow, currColumn + 1)).equals(".")
	        					&& parallelUniverse(map, currRow, currColumn, "DOWN")) {
	        				map.replace(pntToStr(currRow, currColumn + 1), map.get(pntToStr(currRow, currColumn + 1)) + "W");
	        				result++;
	        			}
	        			currColumn++;
	        		}
	        	}
	        	else if("DOWN".equals(direction)) {
	        		if(map.containsKey(pntToStr(currRow + 1, currColumn))
	        				&& map.get(pntToStr(currRow + 1, currColumn)).contains("#")) {
	        			direction = "LEFT";
	            		map.replace(pntToStr(currRow, currColumn), map.get(pntToStr(currRow, currColumn)) + "V");
	        		}
	        		else {
	            		map.replace(pntToStr(currRow, currColumn), map.get(pntToStr(currRow, currColumn)) + "V");
	        			if(map.containsKey(pntToStr(currRow + 1, currColumn))
	        					&& map.get(pntToStr(currRow + 1, currColumn)).equals(".")
	        					&& parallelUniverse(map, currRow, currColumn, "LEFT")) {
	        				map.replace(pntToStr(currRow + 1, currColumn), map.get(pntToStr(currRow + 1, currColumn)) + "W");
	        				result++;
	        			}
	        			currRow++;
	        		}
	        	}
	        	else if("LEFT".equals(direction)) {
	        		if(map.containsKey(pntToStr(currRow, currColumn - 1))
	        				&& map.get(pntToStr(currRow, currColumn - 1)).contains("#")) {
	        			direction = "UP";
	        			map.replace(pntToStr(currRow, currColumn), map.get(pntToStr(currRow, currColumn)) + "<");
	        		}
	        		else {
	        			map.replace(pntToStr(currRow, currColumn), map.get(pntToStr(currRow, currColumn)) + "<");
	        			if(map.containsKey(pntToStr(currRow, currColumn - 1))
	        					&& map.get(pntToStr(currRow, currColumn - 1)).equals(".")
	        					&& parallelUniverse(map, currRow, currColumn, "UP")) {
	        				map.replace(pntToStr(currRow, currColumn - 1), map.get(pntToStr(currRow, currColumn - 1)) + "W");
	        				result++;
	        			}
	        			currColumn--;
	        		}
	        	}
	        }
		
	        //1793
	        System.out.println("Day 06 Part 2 Result: " + result);
	        read.close();
	}
	
	private static String pntToStr(int x, int y) {
		return String.valueOf(x) + "," + String.valueOf(y);
	}
	
	private static boolean parallelUniverse(HashMap<String, String> inMap, int row, int col, String direction) {
		
		@SuppressWarnings("unchecked")
		HashMap<String, String> map = (HashMap<String, String>)inMap.clone();
		
		map.replace(pntToStr(row, col), map.get(pntToStr(row, col)) + "S");
		
		if("UP".equals(direction) && map.containsKey(pntToStr(row, col - 1))) {
			map.replace(pntToStr(row, col - 1), map.get(pntToStr(row, col - 1)) + "#");
		}
		else if("RIGHT".equals(direction) && map.containsKey(pntToStr(row - 1, col))) {
			map.replace(pntToStr(row - 1, col), map.get(pntToStr(row - 1, col)) + "#");
		}
		else if("DOWN".equals(direction) && map.containsKey(pntToStr(row, col + 1))) {
			map.replace(pntToStr(row, col + 1), map.get(pntToStr(row, col + 1)) + "#");
		}
		else if("LEFT".equals(direction) && map.containsKey(pntToStr(row + 1, col))) {
			map.replace(pntToStr(row + 1, col), map.get(pntToStr(row + 1, col)) + "#");
		}
		
		
		while(map.containsKey(pntToStr(row, col))) {
			if("UP".equals(direction)) {
				if(map.containsKey(pntToStr(row - 1, col))
						&& map.get(pntToStr(row - 1, col)).contains("#")) {
					if(map.get(pntToStr(row, col)).contains("^")) {
						return true;
					}
					else {
		        			direction = "RIGHT";
						map.replace(pntToStr(row, col), map.get(pntToStr(row, col)) + "^");
						
					}
        		}
				else {
					map.replace(pntToStr(row, col), map.get(pntToStr(row, col)) + "^");
					row--;
				}
			}
			else if("RIGHT".equals(direction)) {
				if(map.containsKey(pntToStr(row, col + 1))
        				&& map.get(pntToStr(row, col + 1)).contains("#")) {
					if(map.get(pntToStr(row, col)).contains(">")) {
						return true;
					}
					else {
		        			direction = "DOWN";
						map.replace(pntToStr(row, col), map.get(pntToStr(row, col)) + ">");
					}
        		}
				else {
					map.replace(pntToStr(row, col), map.get(pntToStr(row, col)) + ">");
					col++;
				}
			}
			else if("DOWN".equals(direction)) {
				if(map.containsKey(pntToStr(row + 1, col))
        				&& map.get(pntToStr(row + 1, col)).contains("#")) {
					if(map.get(pntToStr(row, col)).contains("V")) {
						return true;
					}
					else {
		        			direction = "LEFT";
						map.replace(pntToStr(row, col), map.get(pntToStr(row, col)) + "V");
					}
        		}
				else {
					map.replace(pntToStr(row, col), map.get(pntToStr(row, col)) + "V");
					row++;
				}
			}
			else if("LEFT".equals(direction)) {
				if(map.containsKey(pntToStr(row, col - 1))
        				&& map.get(pntToStr(row, col - 1)).contains("#")) {
					if(map.get(pntToStr(row, col)).contains("<")) {
						return true;
					}
					else {
		        			direction = "UP";
						map.replace(pntToStr(row, col), map.get(pntToStr(row, col)) + "<");
					}
        		}
				else {
					map.replace(pntToStr(row, col), map.get(pntToStr(row, col)) + "<");
					col--;
				}
			}
		}
		return false;
	}
	
	//Debug Function
	@SuppressWarnings("unused")
	private static void printMap(HashMap<String, String> map) {
		for(int i = 0; i < 130; i++) {
			for(int j = 0; j < 130; j++) {
				System.out.print(map.get(pntToStr(i,j)) + "\t");
			}
			System.out.println();
		}
		
	}
}
