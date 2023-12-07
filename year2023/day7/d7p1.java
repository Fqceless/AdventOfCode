package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class d7p1 {
	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\AdventOfYourMother2023\\src\\day7\\d7in.txt");
        Scanner read = new Scanner(in);
        
        int ret = 0;
        
        ArrayList<String> hands = new ArrayList<>();
        ArrayList<Integer> bids = new ArrayList<>();
        HashMap<String, Integer> handsToBids = new HashMap<>();
        ArrayList<String> sortedHands = new ArrayList<>();
        
        ArrayList<ArrayList<String>> allHands = new ArrayList<>();
        ArrayList<String> fiveKindHands = new ArrayList<>();
        allHands.add(fiveKindHands);
        ArrayList<String> fourKindHands = new ArrayList<>();
        allHands.add(fourKindHands);
        ArrayList<String> fullHouseHands = new ArrayList<>();
        allHands.add(fullHouseHands);
        ArrayList<String> threeKindHands = new ArrayList<>();
        allHands.add(threeKindHands);
        ArrayList<String> twoPairHands = new ArrayList<>();
        allHands.add(twoPairHands);
        ArrayList<String> onePairHands = new ArrayList<>();
        allHands.add(onePairHands);
        ArrayList<String> highCardHands = new ArrayList<>();
        allHands.add(highCardHands);
        
        while(read.hasNext()) {
        	String[] line = read.nextLine().split(" ");
        	hands.add(line[0]);
        	bids.add(Integer.parseInt(line[1]));
        }
        
        for(int i = 0; i < hands.size(); i++) {
        	char[] stringArray = hands.get(i).toCharArray();
        	Arrays.sort(stringArray);
        	sortedHands.add(new String(stringArray));
        	
        	handsToBids.put(hands.get(i), bids.get(i));
        }
        
        
        for(int i = 0; i < sortedHands.size(); i++) {
        	if(sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(1) && 
        			sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(2) && 
        			sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(3) && 
        			sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(4)) {
        		fiveKindHands.add(hands.get(i));
        	}
        	else if(sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(1) && 
        			sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(2) && 
        			sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(3) ||
        			sortedHands.get(i).charAt(1) == sortedHands.get(i).charAt(2) && 
        			sortedHands.get(i).charAt(1) == sortedHands.get(i).charAt(3) && 
        			sortedHands.get(i).charAt(1) == sortedHands.get(i).charAt(4)) {
        		fourKindHands.add(hands.get(i));
        	}
        	else if(sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(1) && 
        			sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(2) && 
        			sortedHands.get(i).charAt(3) == sortedHands.get(i).charAt(4) ||
        			sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(1) && 
        			sortedHands.get(i).charAt(2) == sortedHands.get(i).charAt(3) && 
        			sortedHands.get(i).charAt(2) == sortedHands.get(i).charAt(4)) {
        		fullHouseHands.add(hands.get(i));
        	}
        	else if(sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(1) && 
        			sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(2) ||
        			sortedHands.get(i).charAt(1) == sortedHands.get(i).charAt(2) && 
        			sortedHands.get(i).charAt(1) == sortedHands.get(i).charAt(3) ||
        			sortedHands.get(i).charAt(2) == sortedHands.get(i).charAt(3) && 
        			sortedHands.get(i).charAt(2) == sortedHands.get(i).charAt(4)) {
        		threeKindHands.add(hands.get(i));
        	}
        	else if(sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(1) && 
        			sortedHands.get(i).charAt(2) == sortedHands.get(i).charAt(3) ||
        			sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(1) && 
        			sortedHands.get(i).charAt(3) == sortedHands.get(i).charAt(4) ||
        			sortedHands.get(i).charAt(1) == sortedHands.get(i).charAt(2) && 
        			sortedHands.get(i).charAt(3) == sortedHands.get(i).charAt(4)) {
        		twoPairHands.add(hands.get(i));
        	}
        	else if(sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(1) || 
        			sortedHands.get(i).charAt(1) == sortedHands.get(i).charAt(2) ||
        			sortedHands.get(i).charAt(2) == sortedHands.get(i).charAt(3) || 
        			sortedHands.get(i).charAt(3) == sortedHands.get(i).charAt(4)) {
        		onePairHands.add(hands.get(i));
        	}
        	else {
        		highCardHands.add(hands.get(i));
        	}
        }
        
        for(ArrayList<String> list : allHands) {
    		list.sort(new HandComparator());
    	}
    	
        int rank = 1;
    	for(int i = allHands.size()-1; i >= 0; i--) {
    		for(int j = allHands.get(i).size()-1; j >= 0; j--) {
    			ret += rank * handsToBids.get(allHands.get(i).get(j));
    			rank++;
    		}
    	}
        
        System.out.println(ret);
	}
}

class HandComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		for(int i = 0; i < s1.length(); i++) {
			if(returnValue(s1.charAt(i)) < returnValue(s2.charAt(i))){
				return -1;
			}
			else if(returnValue(s1.charAt(i)) > returnValue(s2.charAt(i))) {
				return 1;
			}
		}
		return 0;
	}
	
	private int returnValue(Character c) {
		switch(c) {
			case 'A' -> {return 0;}
			case 'K' -> {return 1;}
			case 'Q' -> {return 2;}
			case 'J' -> {return 3;}
			case 'T' -> {return 4;}
			case '9' -> {return 5;}
			case '8' -> {return 6;}
			case '7' -> {return 7;}
			case '6' -> {return 8;}
			case '5' -> {return 9;}
			case '4' -> {return 10;}
			case '3' -> {return 11;}
			case '2' -> {return 12;}
			default ->  {return 999;}
		}
	}
}
