package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class d3p2 {
	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\AdventOfYourMother2023\\src\\day3\\d3in.txt");
        Scanner read = new Scanner(in);
        ArrayList<String> map = new ArrayList<>();
        int ret = 0;
        int index;
        int offset;
        String num;
        
        while(read.hasNext()) {
        	map.add(read.nextLine());
        }
        
        for(int i = 0; i < map.size(); i++) {
        	for(int j = 0; j < map.get(i).length(); j++) {
        		char currChar = map.get(i).charAt(j);
        		if(currChar == '*') {
            		ArrayList<Integer> nums = new ArrayList<>();
                    ArrayList<Character> gearList = new ArrayList<>();
        			index = j;
        			for(int k = i - 1; k <= i + 1; k++) {
    					for(int l = index - 1; l <= index + 1; l++) {
    						try {
    							gearList.add(map.get(k).charAt(l));
    						}
    						catch(Exception e){
    							gearList.add('.');
    						}
    					}
        			}
        			if(Character.isDigit(gearList.get(0)) && Character.isDigit(gearList.get(2)) && !Character.isDigit(gearList.get(1))){
        				offset = -2;
        				num = Character.toString(gearList.get(0));
        				while(index + offset >= 0 && index + offset < map.get(i).length() && Character.isDigit(map.get(i - 1).charAt(index + offset))) {
        					num = map.get(i - 1).charAt(index + offset) + num;        					
        					offset--;
        				}
        				nums.add(Integer.parseInt(num));
        				
        				offset = 2;
        				num = Character.toString(gearList.get(2));
        				while(index + offset >= 0 && index + offset < map.get(i).length() && Character.isDigit(map.get(i - 1).charAt(index + offset))) {
        					num += map.get(i - 1).charAt(index + offset);
        					offset++;
        				}
        				nums.add(Integer.parseInt(num));
        			}
        			else if(Character.isDigit(gearList.get(1))){
        				offset = -1;
        				num = Character.toString(gearList.get(1));
        				while(index + offset >= 0 && index + offset < map.get(i).length() && Character.isDigit(map.get(i - 1).charAt(index + offset))) {
        					num = map.get(i - 1).charAt(index + offset) + num;
        					offset--;
        				}
        				offset = 1;
        				while(index + offset >= 0 && index + offset < map.get(i).length() && Character.isDigit(map.get(i - 1).charAt(index + offset))) {
        					num += map.get(i - 1).charAt(index + offset);
        					offset++;
        				}
        				nums.add(Integer.parseInt(num));
        			}
        			else if(Character.isDigit(gearList.get(0)) && !Character.isDigit(gearList.get(2)) && !Character.isDigit(gearList.get(1))){
        				offset = -2;
        				num = Character.toString(gearList.get(0));
        				while(index + offset >= 0 && index + offset < map.get(i).length() && Character.isDigit(map.get(i - 1).charAt(index + offset))) {
        					num = map.get(i - 1).charAt(index + offset) + num;
        					offset--;
        				}
        				nums.add(Integer.parseInt(num));
        			}
        			else if(!Character.isDigit(gearList.get(0)) && Character.isDigit(gearList.get(2)) && !Character.isDigit(gearList.get(1))){
        				offset = 2;
        				num = Character.toString(gearList.get(2));
        				while(index + offset >= 0 && index + offset < map.get(i).length() && Character.isDigit(map.get(i - 1).charAt(index + offset))) {
        					num += map.get(i - 1).charAt(index + offset);
        					offset++;
        				}
        				nums.add(Integer.parseInt(num));
        			}
        			if(Character.isDigit(gearList.get(6)) && Character.isDigit(gearList.get(8)) && !Character.isDigit(gearList.get(7))){
        				offset = -2;
        				num = Character.toString(gearList.get(6));
        				while(index + offset >= 0 && index + offset < map.get(i).length() && Character.isDigit(map.get(i + 1).charAt(index + offset))) {
        					num = map.get(i + 1).charAt(index + offset) + num;
        					offset--;
        				}
        				nums.add(Integer.parseInt(num));
        				
        				offset = 2;
        				num = Character.toString(gearList.get(8));
        				while(index + offset >= 0 && index + offset < map.get(i).length() && Character.isDigit(map.get(i + 1).charAt(index + offset))) {
        					num += map.get(i + 1).charAt(index + offset);
        					offset++;
        				}
        				nums.add(Integer.parseInt(num));
        			}
        			else if(Character.isDigit(gearList.get(7))){
        				offset = -1;
        				num = Character.toString(gearList.get(7));
        				while(index + offset >= 0 && index + offset < map.get(i).length() && Character.isDigit(map.get(i + 1).charAt(index + offset))) {
        					num = map.get(i + 1).charAt(index + offset) + num;
        					offset--;
        				}
        				
        				offset = 1;
        				while(index + offset >= 0 && index + offset < map.get(i).length() && Character.isDigit(map.get(i + 1).charAt(index + offset))) {
        					num += map.get(i + 1).charAt(index + offset);
        					offset++;
        				}
        				nums.add(Integer.parseInt(num));
        			}
        			else if(Character.isDigit(gearList.get(6)) && !Character.isDigit(gearList.get(8)) && !Character.isDigit(gearList.get(7))){
        				offset = -2;
        				num = Character.toString(gearList.get(6));
        				while(index + offset >= 0 && index + offset < map.get(i).length() && Character.isDigit(map.get(i + 1).charAt(index + offset))) {
        					num = map.get(i + 1).charAt(index + offset) + num;
        					offset--;
        				}
        				nums.add(Integer.parseInt(num));
        			}
        			else if(!Character.isDigit(gearList.get(6)) && Character.isDigit(gearList.get(8)) && !Character.isDigit(gearList.get(7))){
        				offset = 2;
        				num = Character.toString(gearList.get(8));
        				while(index + offset >= 0 && index + offset < map.get(i).length() && Character.isDigit(map.get(i + 1).charAt(index + offset))) {
        					num += map.get(i + 1).charAt(index + offset);
        					offset++;
        				}
        				nums.add(Integer.parseInt(num));
        			}
        			if(Character.isDigit(gearList.get(3))){
        				offset = -2;
        				num = Character.toString(gearList.get(3));
        				while(index + offset >= 0 && index + offset < map.get(i).length() && Character.isDigit(map.get(i).charAt(index + offset))) {
        					num = map.get(i).charAt(index + offset) + num;
        					offset--;
        				}
        				nums.add(Integer.parseInt(num));
        			}
        			if(Character.isDigit(gearList.get(5))){
        				offset = 2;
        				num = Character.toString(gearList.get(5));
        				while(index + offset >= 0 && index + offset < map.get(i).length() && Character.isDigit(map.get(i).charAt(index + offset))) {
        					num += map.get(i).charAt(index + offset);
        					offset++;
        				}
        				nums.add(Integer.parseInt(num));
        			}
        			
        			for(int q = 0; q <= 8; q++) {
        				System.out.print(gearList.get(q));
        				if(q == 2 || q == 5 || q == 8) {
        					System.out.println();
        				}
        			}
        			for(int q : nums) {
        				System.out.print(q + " ");
        			}
        			System.out.println("\n");
        			
        			
        			if(nums.size() == 2) {
        				ret += nums.get(0) * nums.get(1);
        			}
        			
        		}
        	}
        }
        System.out.println(ret);
	}
}
