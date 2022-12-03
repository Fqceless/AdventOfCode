package aoc22;

import java.io.*;
import java.util.*;

public class Day3 {
    public static int compute() throws FileNotFoundException{
        File in = new File("C:\\Users\\clafa\\OneDrive\\Documents\\NetBeansProjects\\AdventOfCode2022\\src\\main\\java\\aoc22\\dayThreeIn.txt");
        Scanner read = new Scanner(in);
        System.out.println();
        
        //String str;
        String first;
        String second;
        String third;
        Stack<Character> matchStack = new Stack<>();
        int sum = 0;
        boolean foundMatch = false;
        while(read.hasNext()){
            //str = read.nextLine();
            first = read.nextLine();
            second = read.nextLine();
            third = read.nextLine();
            
            for(int i = 0; i < first.length(); i++){
                for(int j = 0; j < second.length(); j++){
                    for(int k = 0; k < third.length(); k++){
                        if((first.charAt(i) == second.charAt(j)
                        && second.charAt(j) == third.charAt(k))
                        && foundMatch == false){
                            matchStack.add(first.charAt(i));
                            foundMatch = true;
                        }
                    }
                }
            }
            foundMatch = false;
        }
        while(!matchStack.isEmpty()){
            sum += toPriority(matchStack.pop());
        }
        return sum;
    }
    
    public static int toPriority(char c){
        int pri;
        switch(c){
                case 'a' -> pri = 1;
                case 'b' -> pri = 2;
                case 'c' -> pri = 3;
                case 'd' -> pri = 4;
                case 'e' -> pri = 5;
                case 'f' -> pri = 6;
                case 'g' -> pri = 7;
                case 'h' -> pri = 8;
                case 'i' -> pri = 9;
                case 'j' -> pri = 10;
                case 'k' -> pri = 11;
                case 'l' -> pri = 12;
                case 'm' -> pri = 13;
                case 'n' -> pri = 14;
                case 'o' -> pri = 15;
                case 'p' -> pri = 16;
                case 'q' -> pri = 17;
                case 'r' -> pri = 18;
                case 's' -> pri = 19;
                case 't' -> pri = 20;
                case 'u' -> pri = 21;
                case 'v' -> pri = 22;
                case 'w' -> pri = 23;
                case 'x' -> pri = 24;
                case 'y' -> pri = 25;
                case 'z' -> pri = 26;
                case 'A' -> pri = 27;
                case 'B' -> pri = 28;
                case 'C' -> pri = 29;
                case 'D' -> pri = 30;
                case 'E' -> pri = 31;
                case 'F' -> pri = 32;
                case 'G' -> pri = 33;
                case 'H' -> pri = 34;
                case 'I' -> pri = 35;
                case 'J' -> pri = 36;
                case 'K' -> pri = 37;
                case 'L' -> pri = 38;
                case 'M' -> pri = 39;
                case 'N' -> pri = 40;
                case 'O' -> pri = 41;
                case 'P' -> pri = 42;
                case 'Q' -> pri = 43;
                case 'R' -> pri = 44;
                case 'S' -> pri = 45;
                case 'T' -> pri = 46;
                case 'U' -> pri = 47;
                case 'V' -> pri = 48;
                case 'W' -> pri = 49;
                case 'X' -> pri = 50;
                case 'Y' -> pri = 51;
                case 'Z' -> pri = 52;
                default -> pri = -1;
            }
        return pri;
    }
}
