package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class d7p2 {
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
        	ArrayList<Character> stringArray = new ArrayList<>();
        	for(char c : hands.get(i).toCharArray()) {
        		stringArray.add(c);
        	}
        	stringArray.sort(new CharComparator2());
        	String hand = "";
        	for(char c : stringArray) {
        		hand += c;
        	}
        	sortedHands.add(hand);
        	
        	handsToBids.put(hands.get(i), bids.get(i));
        }
        
        
        for(int i = 0; i < sortedHands.size(); i++) {
        	if((sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(1) ||
        				sortedHands.get(i).charAt(1) == 'J') &&
        			(sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(2) || 
        				sortedHands.get(i).charAt(2) == 'J') &&
        			(sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(3) || 
        				sortedHands.get(i).charAt(3) == 'J') &&
        			(sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(4) ||
        				sortedHands.get(i).charAt(4) == 'J')) {
        		fiveKindHands.add(hands.get(i));
        	}
        	else if((sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(1) &&
        			sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(2) &&
        			sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(3)) ||
        			(sortedHands.get(i).charAt(1) == sortedHands.get(i).charAt(2) &&
        			sortedHands.get(i).charAt(1) == sortedHands.get(i).charAt(3) &&
        			sortedHands.get(i).charAt(1) == sortedHands.get(i).charAt(4)) ||
        			(threeKind(sortedHands.get(i)) && 
        				sortedHands.get(i).charAt(4) == 'J') ||
        			(onePair(sortedHands.get(i)) && 
        				sortedHands.get(i).charAt(4) == 'J' &&
        				sortedHands.get(i).charAt(3) == 'J') ||
    				(sortedHands.get(i).charAt(4) == 'J' &&
    				sortedHands.get(i).charAt(3) == 'J' &&
    				sortedHands.get(i).charAt(2) == 'J')) {
        		fourKindHands.add(hands.get(i));
        	}
        	else if((sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(1) &&
        			sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(2) && 
        			sortedHands.get(i).charAt(3) == sortedHands.get(i).charAt(4) ||
        			sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(1) && 
        			sortedHands.get(i).charAt(2) == sortedHands.get(i).charAt(3) && 
        			sortedHands.get(i).charAt(2) == sortedHands.get(i).charAt(4)) ||
        			(twoPair(sortedHands.get(i)) && 
        			sortedHands.get(i).charAt(4) == 'J')){
        		fullHouseHands.add(hands.get(i));
        	}
        	else if(threeKind(sortedHands.get(i)) ||
        			onePair(sortedHands.get(i)) && sortedHands.get(i).charAt(4) == 'J' ||
        			(sortedHands.get(i).charAt(4) == 'J' && sortedHands.get(i).charAt(3) == 'J')){
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
        	else if((sortedHands.get(i).charAt(0) == sortedHands.get(i).charAt(1) || 
        			sortedHands.get(i).charAt(1) == sortedHands.get(i).charAt(2) ||
        			sortedHands.get(i).charAt(2) == sortedHands.get(i).charAt(3) || 
        			sortedHands.get(i).charAt(3) == sortedHands.get(i).charAt(4)) ||
        			sortedHands.get(i).charAt(4) == 'J') {
        		onePairHands.add(hands.get(i));
        	}
        	else {
        		highCardHands.add(hands.get(i));
        	}
        }
        
        for(ArrayList<String> list : allHands) {
    		list.sort(new HandComparator2());
    	}
    	
        int rank = 1;
    	for(int i = allHands.size()-1; i >= 0; i--) {
    		for(int j = allHands.get(i).size() - 1; j >= 0; j--) {
    			ret += rank * handsToBids.get(allHands.get(i).get(j));
    			rank++;
    		}
    	}
        
        System.out.println(ret);
	}
	
	private static boolean threeKind(String s) {
		return (s.charAt(0) == s.charAt(1) && 
    			s.charAt(0) == s.charAt(2) ||
    			s.charAt(1) == s.charAt(2) && 
    			s.charAt(1) == s.charAt(3) ||
    			s.charAt(2) == s.charAt(3) && 
    			s.charAt(2) == s.charAt(4));
	}
	
	private static boolean twoPair(String s) {
		return s.charAt(0) == s.charAt(1) && 
    			s.charAt(2) == s.charAt(3) ||
    			s.charAt(0) == s.charAt(1) && 
    			s.charAt(3) == s.charAt(4) ||
    			s.charAt(1) == s.charAt(2) && 
    			s.charAt(3) == s.charAt(4);
	}
	
	private static boolean onePair(String s) {
		return s.charAt(0) == s.charAt(1) || 
    			s.charAt(1) == s.charAt(2) ||
    			s.charAt(2) == s.charAt(3) || 
    			s.charAt(3) == s.charAt(4) &&
    			(s.charAt(3) != 'J' && 
    			s.charAt(4) != 'J');
	}
}

class HandComparator2 implements Comparator<String> {

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
			case 'T' -> {return 3;}
			case '9' -> {return 4;}
			case '8' -> {return 5;}
			case '7' -> {return 6;}
			case '6' -> {return 7;}
			case '5' -> {return 8;}
			case '4' -> {return 9;}
			case '3' -> {return 10;}
			case '2' -> {return 11;}
			case 'J' -> {return 12;}
			default ->  {return 999;}
		}
	}
}

class CharComparator2 implements Comparator<Character> {

	@Override
	public int compare(Character c1, Character c2) {
		return returnValue(c1) - returnValue(c2);
	}
	
	private int returnValue(Character c) {
		switch(c) {
			case 'A' -> {return 0;}
			case 'K' -> {return 1;}
			case 'Q' -> {return 2;}
			case 'T' -> {return 3;}
			case '9' -> {return 4;}
			case '8' -> {return 5;}
			case '7' -> {return 6;}
			case '6' -> {return 7;}
			case '5' -> {return 8;}
			case '4' -> {return 9;}
			case '3' -> {return 10;}
			case '2' -> {return 11;}
			case 'J' -> {return 12;}
			default ->  {return 999;}
		}
	}
}
