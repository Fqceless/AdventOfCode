package aoc22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static int compute() throws FileNotFoundException{
        File in = new File("C:\\Users\\clafa\\OneDrive\\Documents\\NetBeansProjects\\AdventOfCode2022\\src\\main\\java\\aoc22\\dayTwoIn.txt");
        Scanner read = new Scanner(in);
        String oppMove;
        String yourMove;
        int score = 0;
        
        //Rock A
        //Paper B
        //Scissors C
        //Lose X
        //Tie Y
        //Win Z
        
        while(read.hasNext()){
            oppMove = read.next();
            yourMove = read.next();
            
            switch(yourMove){
                case "Z" -> score += 6;
                case "Y" -> score += 3;
                case "X" -> score += 0;
            }
            
            switch (rightMove(oppMove, yourMove)) {
                case "R" -> score += 1;
                case "P" -> score += 2;
                case "S" -> score += 3;
            }
        }
        return score;
    }
    
    //part 1
    public static String didWin(String O, String U){
        if ((O.equals("A") && U.equals("Y")) || 
            (O.equals("B") && U.equals("Z")) || 
            (O.equals("C") && U.equals("X"))){
            return "W";
        }
        else if ((O.equals("A") && U.equals("X")) || 
                 (O.equals("B") && U.equals("Y")) || 
                 (O.equals("C") && U.equals("Z"))){
            return "T";
        }
        return "L";
    }
    
    //part 2
    public static String rightMove(String O, String U){
        if ((O.equals("A") && U.equals("X")) ||
            (O.equals("B") && U.equals("Z")) ||
            (O.equals("C") && U.equals("Y"))){
            return "S";
        }
        else if ((O.equals("A") && U.equals("Z")) ||
                 (O.equals("B") && U.equals("Y")) ||
                 (O.equals("C") && U.equals("X"))){
            return "P";
        }
        return "R";
    }
}
