package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class d6p2 {
	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\AdventOfYourMother2023\\src\\day6\\d6in.txt");
        Scanner read = new Scanner(in);
        
        ArrayList<Integer> timeList = new ArrayList<>();
        ArrayList<Integer> distanceList = new ArrayList<>();
        
        for(String num : read.nextLine().split(" ")) {
        	try {
        		timeList.add(Integer.parseInt(num));
        	} catch (Exception e ) {}
        }
        
        String times = "";
        for(Integer num : timeList) {
        	times += Integer.toString(num);
        }
        long time = Long.parseLong(times);
        
        for(String num : read.nextLine().split(" ")) {
        	try {
        		distanceList.add(Integer.parseInt(num));
        	} catch (Exception e ) {}
        }
        
        String distances = "";
        for(Integer num : distanceList) {
        	distances += Integer.toString(num);
        }
        long distance = Long.parseLong(distances);
        
        
    	int count = 0;
    	for(long j = 0; j <= time; j++) {
    		long yourDistance = j * (time - j);
    		if(yourDistance > distance) {
    			count++;
    		}
    	}
        	
        System.out.println(count);
	}
}
