package aoc22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Day6 {
    public static int compute() throws FileNotFoundException{
        File in = new File("C:\\Users\\clafa\\OneDrive\\Documents\\NetBeansProjects\\AdventOfCode2022\\src\\main\\java\\aoc22\\daySixIn.txt");
        Scanner read = new Scanner(in);
        String data = read.nextLine();
        String dataSubstring;
        for(int i = 13; i < data.length(); i++){
            dataSubstring = data.substring(i - 13, i + 1);
            for(int j = 0; j < dataSubstring.length(); j++){
                if(dataSubstring.substring(j + 1).contains(Character.toString(dataSubstring.charAt(j)))){
                    j = dataSubstring.length();
                }
                else if(j == dataSubstring.length() - 1){
                    return i + 1;
                }
            }
        }
        return -1;
    }
}
