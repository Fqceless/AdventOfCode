package aoc22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {
    public static int compute() throws FileNotFoundException{
        File in = new File("C:\\Users\\clafa\\OneDrive\\Documents\\NetBeansProjects\\AdventOfCode2022\\src\\main\\java\\aoc22\\dayFourIn.txt");
        Scanner read = new Scanner(in);
        String[] strArray;
        int counter = 0;
        while(read.hasNext()){
            strArray = read.nextLine().split(",");
            if(doesOverlap(strArray[0], strArray[1])){
                counter++;
            }
        }
        return counter;
    }
    
    public static boolean doesEngulf(String first, String last){
        String[] firstArray = first.split("-");
        String[] lastArray = last.split("-");
        if(Integer.parseInt(firstArray[0]) <= Integer.parseInt(lastArray[0])
           && Integer.parseInt(firstArray[1]) >= Integer.parseInt(lastArray[1])){
            return true;
        }
        else if(Integer.parseInt(firstArray[0]) >= Integer.parseInt(lastArray[0])
                && Integer.parseInt(firstArray[1]) <= Integer.parseInt(lastArray[1])){
            return true;
        }
        return false;
    }
    
    public static boolean doesOverlap(String first, String last){
        String[] firstArray = first.split("-");
        String[] lastArray = last.split("-");
        //this is so gross im so sorry
        if ((Integer.parseInt(lastArray[0]) >= Integer.parseInt(firstArray[0]) 
           && Integer.parseInt(lastArray[0]) <= Integer.parseInt(firstArray[1]))
           || (Integer.parseInt(lastArray[1]) >= Integer.parseInt(firstArray[0]) 
           && Integer.parseInt(lastArray[1]) <= Integer.parseInt(firstArray[1]))
           || (Integer.parseInt(firstArray[1]) >= Integer.parseInt(lastArray[0]) 
           && Integer.parseInt(firstArray[1]) <= Integer.parseInt(lastArray[1]))
           || (Integer.parseInt(firstArray[0]) >= Integer.parseInt(lastArray[0]) 
           && Integer.parseInt(firstArray[0]) <= Integer.parseInt(lastArray[1]))){
            return true;
        }
        return false;
    }
}
