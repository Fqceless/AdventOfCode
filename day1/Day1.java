package aoc22;

import java.io.*;
import java.util.Scanner;

//part one: max is int
//part two: max is array, holds top three
public class Day1 {
    public static int compute() throws FileNotFoundException{
        File in = new File("C:\\Users\\clafa\\OneDrive\\Documents\\NetBeansProjects\\AdventOfCode2022\\src\\main\\java\\aoc22\\dayOneIn.txt");
        Scanner read = new Scanner(in);
        String num = read.nextLine();
        int sum = 0;
        int max[] = new int[3];
        max[0] = -1;
        max[1] = -1;
        max[2] = -1;
        while(read.hasNext()){
            if (!num.equals("")){
                sum += Integer.parseInt(num);
            }
            else{
                if (sum > max[0]){
                    max[2] = max[1];
                    max[1] = max[0];
                    max[0] = sum;
                }
                else if (sum > max[1]){
                    max[2] = max[1];
                    max[1] = sum;
                }
                else if (sum > max[2]){
                    max[2] = sum;
                }
                sum = 0;
            }
            num = read.nextLine();
        }
        return max[0] + max[1] + max[2];
    }
}
