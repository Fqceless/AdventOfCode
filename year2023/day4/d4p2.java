package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class d4p2 {
	static int ret = 0;
	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\AdventOfYourMother2023\\src\\day4\\d4in.txt");
        Scanner read = new Scanner(in);
        ArrayList<String> cardList = new ArrayList<>();
        
        while(read.hasNext()) {
        	cardList.add(read.nextLine());
        }
        
        for(int i = 0; i < cardList.size(); i++) {
        	playCard(i, cardList);
        }
    	
        System.out.println(ret);
	}
	
	private static void playCard(int cardNum, ArrayList<String> cardList) {
		String[] game = cardList.get(cardNum).split("[:|]");
    	String[] winningNums = game[1].split(" ");
    	String[] yourNums = game[2].split(" ");
    	int numMatches = 0;
    	ret++;
    	
    	ArrayList<Integer> winningNumsList = new ArrayList<>();
    	ArrayList<Integer> yourNumsList = new ArrayList<>();
    	
    	for(String s : winningNums) {
    		if(!s.equals("")) {
    			winningNumsList.add(Integer.parseInt(s));
    		}
    	}
    	for(String s : yourNums) {
    		if(!s.equals("")) {
    			yourNumsList.add(Integer.parseInt(s));
    		}
    	}
    	
    	for(int num : winningNumsList) {
    		if(yourNumsList.contains(num)) {
    			numMatches++;
    		}
    	}
    	
    	for(int i = 1; i <= numMatches; i++) {
    		if(cardNum + i <= 201) {
    			playCard(cardNum + i, cardList);
    		}
    	}
	}
}
