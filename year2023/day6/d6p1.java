package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class d6p1 {
	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\AdventOfYourMother2023\\src\\day6\\d6in.txt");
        Scanner read = new Scanner(in);
        
        ArrayList<Integer> timeList = new ArrayList<>();
        ArrayList<Integer> distanceList = new ArrayList<>();
        int ret = 1;
        
        for(String num : read.nextLine().split(" ")) {
        	try {
        		timeList.add(Integer.parseInt(num));
        	} catch (Exception e ) {}
        }
        
        for(String num : read.nextLine().split(" ")) {
        	try {
        		distanceList.add(Integer.parseInt(num));
        	} catch (Exception e ) {}
        }
        
        for(int i = 0; i < timeList.size(); i++) {
        	int count = 0;
        	for(int j = 0; j <= timeList.get(i); j++) {
        		if(j * (timeList.get(i) - j) > distanceList.get(i)) {
        			count++;
        		}
        	}
        	ret *= count;
        }
        System.out.println(ret);
	}
}
