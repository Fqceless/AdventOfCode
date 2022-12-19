package aoc22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8 {
    public static int compute() throws FileNotFoundException{
        File in = new File("C:\\Users\\clafa\\OneDrive\\Documents\\NetBeansProjects\\AdventOfCode2022\\src\\main\\java\\aoc22\\dayEightIn.txt");
        Scanner read = new Scanner(in);
        
        ArrayList<String> map= new ArrayList();
        while(read.hasNext()){
            map.add(read.nextLine());
        }
        int MAP_WIDTH = map.get(0).length();
        int visible = 0;
        int score = 1;
        int maxScore = -1;
        
        for(int line = 0; line < map.size(); line++){
            for(int i = 0; i < MAP_WIDTH; i++){
                score *= (scoreUp(map, line, i, map.get(line).charAt(i)));
                score *= (scoreDown(map, line, i, map.get(line).charAt(i)));
                score *= (scoreLeft(map, line, i, map.get(line).charAt(i)));
                score *= (scoreRight(map, line, i, map.get(line).charAt(i)));
                if(score > maxScore){
                    maxScore = score;
                }
                score = 1;
            }
        }
        
        return maxScore;
    }
    
    public static int scoreUp(ArrayList<String> map, int line, int index, char tree){
        int sight = 1;
        if(line == 0){
            return 0;
        }
        else if(tree > map.get(line - 1).charAt(index)){
            sight += scoreUp(map, line - 1, index, tree);
        }
        return sight;
    }
    
    public static int scoreDown(ArrayList<String> map, int line, int index, char tree){
        int sight = 1;
        if(line == map.size() - 1){
            return 0;
        }
        else if(tree > map.get(line + 1).charAt(index)){
            sight += scoreDown(map, line + 1, index, tree);
        }
        return sight;
    }
    
    public static int scoreLeft(ArrayList<String> map, int line, int index, char tree){
        int sight = 1;
        if(index == 0){
            return 0;
        }
        else if(tree > map.get(line).charAt(index - 1)){
            sight += scoreLeft(map, line, index - 1, tree);
        }
        return sight;
    }
    
    public static int scoreRight(ArrayList<String> map, int line, int index, char tree){
        int sight = 1;
        if(index == map.get(0).length() - 1){
            return 0;
        }
        else if(tree > map.get(line).charAt(index + 1)){
            sight += scoreRight(map, line, index + 1, tree);
        }
        return sight;
    }
}
