package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class d5p1 {
	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\AdventOfYourMother2023\\src\\day5\\d5in.txt");
        Scanner read = new Scanner(in);
        
        ArrayList<Long> seeds = new ArrayList<>();
        for(String num : read.nextLine().split(" ")) {
        	try {
        		seeds.add(Long.parseLong(num));
        	}
        	catch(Exception e) {
        		
        	}
        }
        
        read.nextLine();
        read.nextLine();
        
        ArrayList<ArrayList<Long>> seedToSoilMap = new ArrayList<>();
        while(read.hasNextLong()) {
        	String[] sts = read.nextLine().split(" ");
        	ArrayList<Long> temp = new ArrayList<>();
        	for(String num: sts) {
        		temp.add(Long.parseLong(num));
        	}
        	seedToSoilMap.add(temp);
        }
        
        read.nextLine();
        read.nextLine();
        
        ArrayList<ArrayList<Long>> soilToFertMap = new ArrayList<>();
        while(read.hasNextLong()) {
        	String[] stf = read.nextLine().split(" ");
        	ArrayList<Long> temp = new ArrayList<>();
        	for(String num: stf) {
        		temp.add(Long.parseLong(num));
        	}
        	soilToFertMap.add(temp);
        }
        
        read.nextLine();
        read.nextLine();
        
        ArrayList<ArrayList<Long>> fertToWaterMap = new ArrayList<>();
        while(read.hasNextLong()) {
        	String[] ftw = read.nextLine().split(" ");
        	ArrayList<Long> temp = new ArrayList<>();
        	for(String num: ftw) {
        		temp.add(Long.parseLong(num));
        	}
        	fertToWaterMap.add(temp);
        }
        
        read.nextLine();
        read.nextLine();
        
        ArrayList<ArrayList<Long>> waterToLightMap = new ArrayList<>();
        while(read.hasNextLong()) {
        	String[] wtl = read.nextLine().split(" ");
        	ArrayList<Long> temp = new ArrayList<>();
        	for(String num: wtl) {
        		temp.add(Long.parseLong(num));
        	}
        	waterToLightMap.add(temp);
        }
        
        read.nextLine();
        read.nextLine();
        
        ArrayList<ArrayList<Long>> lightToTempMap = new ArrayList<>();
        while(read.hasNextLong()) {
        	String[] ltt = read.nextLine().split(" ");
        	ArrayList<Long> temp = new ArrayList<>();
        	for(String num: ltt) {
        		temp.add(Long.parseLong(num));
        	}
        	lightToTempMap.add(temp);
        }
        
        read.nextLine();
        read.nextLine();
        
        ArrayList<ArrayList<Long>> tempToHumMap = new ArrayList<>();
        while(read.hasNextLong()) {
        	String[] tth = read.nextLine().split(" ");
        	ArrayList<Long> temp = new ArrayList<>();
        	for(String num: tth) {
        		temp.add(Long.parseLong(num));
        	}
        	tempToHumMap.add(temp);
        }
        
        read.nextLine();
        read.nextLine();
        
        ArrayList<ArrayList<Long>> humToLocMap = new ArrayList<>();
        while(read.hasNextLong()) {
        	String[] htl = read.nextLine().split(" ");
        	ArrayList<Long> temp = new ArrayList<>();
        	for(String num: htl) {
        		temp.add(Long.parseLong(num));
        	}
        	humToLocMap.add(temp);
        }
        
        
        for(int i = 0; i < seeds.size(); i++) {
        	for(ArrayList<Long> sts : seedToSoilMap) {
        		if(seeds.get(i) >= sts.get(1) && seeds.get(i) <= sts.get(1) + sts.get(2)) {
        			System.out.println(seeds.get(i) + " + " + (sts.get(0) - sts.get(1)) + " = " + (seeds.get(i) + (sts.get(0) - sts.get(1))));
        			seeds.set(i, seeds.get(i) + (sts.get(0) - sts.get(1)));
        			break;
        		}
        	}
        	
        	for(ArrayList<Long> stf : soilToFertMap) {
        		if(seeds.get(i) >= stf.get(1) && seeds.get(i) <= stf.get(1) + stf.get(2)) {
        			System.out.println(seeds.get(i) + " + " + (stf.get(0) - stf.get(1)) + " = " + (seeds.get(i) + (stf.get(0) - stf.get(1))));
        			seeds.set(i, seeds.get(i) + (stf.get(0) - stf.get(1)));
        			break;
        		}
        	}
        	
        	for(ArrayList<Long> ftw : fertToWaterMap) {
        		if(seeds.get(i) >= ftw.get(1) && seeds.get(i) <= ftw.get(1) + ftw.get(2)) {
        			System.out.println(seeds.get(i) + " + " + (ftw.get(0) - ftw.get(1)) + " = " + (seeds.get(i) + (ftw.get(0) - ftw.get(1))));
        			seeds.set(i, seeds.get(i) + (ftw.get(0) - ftw.get(1)));
        			break;
        		}
        	}
        	
        	for(ArrayList<Long> wtl : waterToLightMap) {
        		if(seeds.get(i) >= wtl.get(1) && seeds.get(i) <= wtl.get(1) + wtl.get(2)) {
        			System.out.println(seeds.get(i) + " + " + (wtl.get(0) - wtl.get(1)) + " = " + (seeds.get(i) + (wtl.get(0) - wtl.get(1))));
        			seeds.set(i, seeds.get(i) + (wtl.get(0) - wtl.get(1)));
        			break;
        		}
        	}
        	
        	for(ArrayList<Long> ltt : lightToTempMap) {
        		if(seeds.get(i) >= ltt.get(1) && seeds.get(i) <= ltt.get(1) + ltt.get(2)) {
        			System.out.println(seeds.get(i) + " + " + (ltt.get(0) - ltt.get(1)) + " = " + (seeds.get(i) + (ltt.get(0) - ltt.get(1))));
        			seeds.set(i, seeds.get(i) + (ltt.get(0) - ltt.get(1)));
        			break;
        		}
        	}
        	
        	for(ArrayList<Long> tth : tempToHumMap) {
        		if(seeds.get(i) >= tth.get(1) && seeds.get(i) <= tth.get(1) + tth.get(2)) {
        			System.out.println(seeds.get(i) + " + " + (tth.get(0) - tth.get(1)) + " = " + (seeds.get(i) + (tth.get(0) - tth.get(1))));
        			seeds.set(i, seeds.get(i) + (tth.get(0) - tth.get(1)));
        			break;
        		}
        	}
        	
        	for(ArrayList<Long> htl : humToLocMap) {
        		if(seeds.get(i) >= htl.get(1) && seeds.get(i) <= htl.get(1) + htl.get(2)) {
        			System.out.println(seeds.get(i) + " + " + (htl.get(0) - htl.get(1)) + " = " + (seeds.get(i) + (htl.get(0) - htl.get(1))));
        			seeds.set(i, seeds.get(i) + (htl.get(0) - htl.get(1)));
        			break;
        		}
        	}
        }
        
        
        seeds.sort(null);
        System.out.println(seeds.get(0));
	}
}
