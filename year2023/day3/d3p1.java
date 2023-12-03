package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class d3p1 {
	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\AdventOfYourMother2023\\src\\day3\\d3in.txt");
        Scanner read = new Scanner(in);
        ArrayList<String> map = new ArrayList<>();
        int ret = 0;
        int frontIndex;
        int endIndex;
        
        while(read.hasNext()) {
        	map.add(read.nextLine());
        }
        
        for(int i = 0; i < map.size(); i++) {
        	for(int j = 0; j < map.get(i).length(); j++) {
        		//Find Numbers
        		char currChar = map.get(i).charAt(j);
        		boolean isGood = false;
        		if(Character.isDigit(currChar)) {
        			frontIndex = j;
        			while(Character.isDigit(map.get(i).charAt(j)) && j < map.get(i).length() - 1) {
        				j++;
        			}
        			endIndex = j;
        			if(j == map.get(i).length() - 1 && Character.isDigit(map.get(i).charAt(j))){
        				endIndex++;
        			}
        			
        			for(int k = i - 1; k <= i + 1; k++) {
        				if(k >= 0 && k < map.size()) {
        					for(int l = frontIndex - 1; l < endIndex + 1; l++) {
        						if(l >= 0 && l < map.get(k).length() && !(map.get(k).charAt(l) == '.') && !Character.isDigit(map.get(k).charAt(l))) {
        							isGood = true;
        						}
        					}
        				}
        			}
        			if(isGood) {
        				ret += Integer.parseInt(map.get(i).substring(frontIndex, endIndex));
        			}
        		}
        	}
        }
        
        System.out.println(ret);
	}
}
